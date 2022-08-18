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
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> record = new HashMap<>();
        q.add(root);
        cols.add(0);
        int min = 0;
        int max = 0;
        while(q.size() > 0) {
            TreeNode curNode = q.poll();
            int curCol = cols.poll();
            if(!record.containsKey(curCol)) {
                record.put(curCol, new ArrayList<Integer>());
            }
            record.get(curCol).add(curNode.val);
            if(curNode.left != null) {
                q.add(curNode.left);
                int temp = curCol - 1;
                cols.add(temp);
                min = Math.min(min, temp);
            }
            if(curNode.right != null) {
                q.add(curNode.right);
                int temp = curCol + 1;
                cols.add(temp);
                max = Math.max(max, temp);
            }
        }
        for(int i = min; i <= max; i ++) {
            result.add(record.get(i));
        }
        return result;
    }
}