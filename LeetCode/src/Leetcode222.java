import javax.swing.tree.TreeNode;

public class Leetcode222 {
    class Solution {
        public int countNodes(TreeNode root) {
            if(root == null) return 0;
            if(root.left == null && root.right == null)
                return 1;
            int left = countNodes(root.left);
            int right = countNodes(root.right);
            int sum = left + right + 1;
            return sum;
        }
    }
}
