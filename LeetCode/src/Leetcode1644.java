import javax.swing.tree.TreeNode;

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
    private TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;
        dfs(root, p, q);
        return result;
    }
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        boolean head = false;
        if(root.val == p.val || root.val == q.val){
            if(left || right) result = root;
            head = true;
        }
        if(left && right && result == null) result = root;
        return left || right || head;
    }
}