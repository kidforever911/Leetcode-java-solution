import javax.swing.tree.TreeNode;

public class Leetcode110 {
    class Solution {
        int max = Integer.MAX_VALUE;
        public boolean isBalanced(TreeNode root) {
            int result = balance(root);
            if(result == max)
                return false;
            return true;
        }
        private int balance(TreeNode root){
            if(root == null) return 0;
            int left = balance(root.left);
            int right = balance(root.right);
            if(left == max || right == max) return max;
            if(Math.abs(left - right) > 1){
                return max;
            }
            return Math.max(left, right) + 1;
        }
    }
}
