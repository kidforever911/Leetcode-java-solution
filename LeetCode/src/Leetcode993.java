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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0) {
            HashMap<Integer, Integer> record = new HashMap<>();
            int length = q.size();
            for(int i = 0; i < length; i ++) {
                TreeNode cur = q.poll();
                if(cur.left != null){
                    q.add(cur.left);
                    record.put(cur.left.val, cur.val);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                    record.put(cur.right.val, cur.val);
                }
            }
            if(record.containsKey(x) && record.containsKey(y) && record.get(x) != record.get(y)) {
                return true;
            }
        }
        return false;
    }
}