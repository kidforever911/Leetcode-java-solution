import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode144 {
    //recursive
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            preorder(root, result);
            return result;
        }

        private void preorder(TreeNode root, List<Integer> result){
            if(root != null){
                result.add(root.val);
                preorder(root.left,result);
                preorder(root.right, result);
            }
        }
    }

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            if(root == null) return result;
            Stack<TreeNode> record = new Stack<>();
            record.push(root);
            while(!record.isEmpty()){
                TreeNode visiting = record.pop();
                result.add(visiting.val);
                if(visiting.right != null) record.push(visiting.right);
                if(visiting.left != null) record.push(visiting.left);
            }
            return result;
        }
    }
}
