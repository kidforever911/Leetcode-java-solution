import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode107 {
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root == null) return result;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            LinkedList<ArrayList<Integer>> temp = new LinkedList<>();

            while(q.size() > 0){
                ArrayList<Integer> list = new ArrayList<>();
                int size = q.size();
                while(size > 0){
                    TreeNode cur = q.poll();
                    list.add(cur.val);
                    if(cur.left != null)
                        q.add(cur.left);
                    if(cur.right != null)
                        q.add(cur.right);
                    size--;
                }
                temp.addFirst(new ArrayList<>(list));
            }
            result = new ArrayList<>(temp);
            return result;
        }
    }
}
