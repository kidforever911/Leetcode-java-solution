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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root == null) return root;
        if(depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        for(int i = 0; i < depth - 2; i ++) {
            for(int j = q.size() - 1; j >= 0; j --) {
                TreeNode cur = q.poll();
                if(cur.left != null) {
                    q.add(cur.left);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                }
            }
        }
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            left.left = cur.left;
            right.right = cur.right;
            cur.left = left;
            cur.right = right;
        }
        return root;
    }
}