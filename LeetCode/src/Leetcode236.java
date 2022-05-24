/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        dfs(root, p, q);
        return result;
    }

    private int dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return 0;
        int state = dfs(root.left, p, q);
        if(root == p) state |= 1;
        else if(root == q) state |= 2;
        state |= dfs(root.right, p, q);
        if(state == 3 && result == null) result = root;
        return state;
    }
}