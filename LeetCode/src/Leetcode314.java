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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> recordNode = new ArrayDeque<>();
        Queue<Integer> recordCol = new ArrayDeque<>();
        HashMap<Integer, List<Integer>> record = new HashMap<>();
        int min = 0;
        int max = 0;
        recordNode.add(root);
        recordCol.add(0);
        while(!recordNode.isEmpty()) {
            TreeNode curNode = recordNode.poll();
            int curCol = recordCol.poll();
            if(!record.containsKey(curCol)) {
                record.put(curCol, new ArrayList<>());
            }
            record.get(curCol).add(curNode.val);
            if(curNode.left != null) {
                int temp = curCol - 1;
                recordNode.add(curNode.left);
                recordCol.add(temp);
                min = Math.min(temp, min);
            }
            if(curNode.right != null) {
                int temp = curCol + 1;
                recordNode.add(curNode.right);
                recordCol.add(temp);
                max = Math.max(temp, max);
            }
        }
        for(int i = min; i <= max; i ++) {
            result.add(record.get(i));
        }
        return result;
    }
}