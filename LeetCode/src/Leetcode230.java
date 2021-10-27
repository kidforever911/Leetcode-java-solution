import javax.swing.tree.TreeNode;

public class Leetcode230 {
    class Solution {
        private int counter = 0;
        private int result = 0;
        public int kthSmallest(TreeNode root, int k) {
            if(root == null) return 0;
            counter = k;
            helper(root);
            return result;
        }
        private void helper(TreeNode root){
            if(root.left != null){
                helper(root.left);
            }
            counter--;
            if(counter == 0)
                result = root.val;
            if(root.right != null)
                helper(root.right);

        }
    }
}
