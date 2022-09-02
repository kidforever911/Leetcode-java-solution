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
    private int result = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val, root.val);
        return result;
    }

    private void dfs(TreeNode root, int cur, int max) {
        if(root == null) return;
        if(max <= cur) result += 1;
        if(root.left != null) {
            dfs(root.left, root.left.val, Math.max(max, root.left.val));
        }
        if(root.right != null) {
            dfs(root.right, root.right.val, Math.max(max, root.right.val));
        }
        return;
    }
}