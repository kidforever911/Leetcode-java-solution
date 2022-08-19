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
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        Subtree result = dfs(root);
        return result.size;
    }
    private Subtree dfs(TreeNode root) {
        if(root == null) return new Subtree(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        Subtree left = dfs(root.left);
        Subtree right = dfs(root.right);
        if(root.val > left.max && root.val < right.min) {
            return new Subtree(Math.min(root.val, left.min), Math.max(root.val, right.max), left.size + right.size + 1);
        }else{
            return new Subtree(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
        }
    }
    class Subtree{
        int min;
        int max;
        int size;
        public Subtree(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
}