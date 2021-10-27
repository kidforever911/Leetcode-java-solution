import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Leetcode113 {
    //dfs
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        pathSum(root, sum, res, new ArrayList<Integer>());
        return res;
    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp){
        if(root == null) return;

        temp.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            res.add(new ArrayList<Integer>(temp));
        }else{
            if(root.left != null){
                pathSum(root.left, sum - root.val, res, temp);
            }
            if(root.right != null){
                pathSum(root.right, sum - root.val, res, temp);
            }
        }
        temp.remove(temp.size() - 1);
    }
}
