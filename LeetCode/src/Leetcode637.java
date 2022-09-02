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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> record = new LinkedList<>();
        record.add(root);
        while(record.size() > 0) {
            int length = record.size();
            double sum = 0.0;
            int count = 0;
            for(int i = 0; i < length; i ++) {
                TreeNode cur = record.poll();
                sum += cur.val;
                count ++;
                if(cur.left != null) {
                    record.add(cur.left);
                }
                if(cur.right != null) {
                    record.add(cur.right);
                }
            }
            result.add(sum / count);
        }
        return result;
    }
}