import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int left, int right){
        List<TreeNode> result = new ArrayList<>();
        if(left > right){
            result.add(null);
            return result;
        }

        for(int i = left; i <= right; i ++){
            List<TreeNode> l = dfs(left, i - 1);
            List<TreeNode> r = dfs(i + 1, right);
            for(TreeNode tempLeft : l){
                for(TreeNode tempRight : r){
                    TreeNode root = new TreeNode(i);
                    root.left = tempLeft;
                    root.right = tempRight;
                    result.add(root);
                }
            }
        }
        return result;
    }
}