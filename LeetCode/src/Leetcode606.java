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
    private StringBuilder result = new StringBuilder();
    public String tree2str(TreeNode root) {
        if(root == null) return "";
        dfs(root);
        return result.toString();
    }

    private void dfs(TreeNode root) {
        if(root == null) return;
        result.append(Integer.toString(root.val));
        if(root.left != null || root.right != null) {
            result.append("(");
            dfs(root.left);
            result.append(")");
        }
        if(root.right != null) {
            result.append("(");
            dfs(root.right);
            result.append(")");
        }
        return;
    }
}