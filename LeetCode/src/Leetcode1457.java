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
    private int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] record = new int[10];
        dfs(root, record);
        return count;
    }

    private void dfs(TreeNode root, int[] record) {
        record[root.val] += 1;
        if(root.left == null && root.right == null) {
            int temp = 0;
            for(int i = 0; i < record.length; i ++) {
                if(record[i] % 2 == 1) {
                    temp ++;
                }
            }
            if(temp <= 1) {
                count ++;
            }
        }
        if(root.left != null) {
            dfs(root.left, record);
            record[root.left.val] -= 1;
        }
        if(root.right != null) {
            dfs(root.right, record);
            record[root.right.val] -= 1;
        }
        return;
    }
}