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
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        HashMap<Integer, Integer> record = new HashMap<>();
        dfs(root, record);
        int maxCount = Integer.MIN_VALUE;
        for(int x : record.keySet()) {
            maxCount = Math.max(maxCount, record.get(x));
        }
        List<Integer> list = new ArrayList<>();
        for(int x : record.keySet()) {
            if(record.get(x) == maxCount) {
                list.add(x);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i ++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private int dfs(TreeNode root, HashMap<Integer, Integer> record) {
        if(root == null) {
            return 0;
        }
        int left = dfs(root.left, record);
        int right = dfs(root.right, record);
        int sum = root.val + left + right;
        record.put(sum, record.getOrDefault(sum, 0) + 1);
        return sum;
    }
}