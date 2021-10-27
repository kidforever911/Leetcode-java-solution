import javax.swing.tree.TreeNode;

public class Leetcode129 {
    //iteration
    public class Solution {
        int total;

        public int sumNumbers(TreeNode root) {
            total = 0;
            rootSum(root, 0);
            return total;
        }

        private void rootSum(TreeNode root, int sum){
            if(root == null) return;
            sum = sum * 10 + root.val;
            if(root.left == null && root.right == null){
                total += sum;
                return;
            }else{
                if(root.left != null){
                    rootSum(root.left, sum);
                }
                if(root.right != null){
                    rootSum(root.right, sum);
                }
            }

        }
    }

    public class Solution {
        public int sumNumbers(TreeNode root) {
            return rootSum(root, 0);
        }
        private int rootSum(TreeNode root, int sum){
            if(root == null) return 0;
            int currentSum = sum * 10 + root.val;
            if(root.left == null && root.right == null) return currentSum;
            int leftSum = rootSum(root.left, currentSum);
            int rightSum = rootSum(root.right, currentSum);
            return leftSum + rightSum;
        }

}
