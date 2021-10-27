import javax.swing.tree.TreeNode;
import java.util.Stack;

public class Leetcode404 {
    class Solution {
        int sum = 0;
        public int sumOfLeftLeaves(TreeNode root) {
            helper(root, false);
            return sum;
        }

        private void helper(TreeNode root, boolean isLeft){
            if(root == null) return;
            if(root.left == null && root.right == null){
                if(isLeft){
                    sum += root.val;
                }
            }
            helper(root.left, true);
            helper(root.right, false);
        }
    }

    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if(root == null) return 0;
            int result = 0;
            if(root.left != null){
                if(root.left.left == null && root.left.right == null){
                    result += root.left.val;
                }else{
                    result += sumOfLeftLeaves(root.left);
                }
            }

            result += sumOfLeftLeaves(root.right);
            return result;

        }
    }

    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            Stack<TreeNode> record = new Stack<>();
            record.push(root);
            int result = 0;
            while(!record.isEmpty()){
                TreeNode node = record.pop();
                if(node.left != null){
                    if(node.left.left == null && node.left.right == null){
                        result += node.left.val;
                    }else{
                        record.push(node.left);
                    }
                }
                if(node.right != null){
                    if(node.right.left != null || node.right.right != null){
                        record.push(node.right);
                    }
                }
            }
            return result;

        }
    }


}
