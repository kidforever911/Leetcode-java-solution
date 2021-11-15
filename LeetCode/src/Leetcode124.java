import javax.swing.tree.TreeNode;

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
//树中枚举路径，是枚举路径的最高点
class Solution {
    private int result;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        result = Integer.MIN_VALUE;
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        result = Math.max(result, root.val + left + right);
        //返回下层节点最大值到上一层节点
        return root.val + Math.max(left, right);
    }
}