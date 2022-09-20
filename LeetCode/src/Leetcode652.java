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
    private int idx = 0;
    private HashMap<String, Integer> record;
    private HashMap<Integer, Integer> count;
    private List<TreeNode> result;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        record = new HashMap<>();
        count = new HashMap<>();
        result = new ArrayList<>();
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        String key = Integer.toString(root.val) + " " + Integer.toString(left) + " " + Integer.toString(right);
        if(!record.containsKey(key)) record.put(key, ++ idx);
        int id = record.get(key);
        count.put(id, count.getOrDefault(id, 0) + 1);
        if(count.get(id) == 2) result.add(root);
        return id;
    }
}