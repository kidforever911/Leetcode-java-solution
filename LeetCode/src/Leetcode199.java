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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> record = new LinkedList<>();
        record.add(root);
        while(record.size() != 0){
            int length = record.size();
            for(int i = 0; i < length; i ++){
                TreeNode temp = record.peek();
                record.poll();
                if(temp.left != null) record.add(temp.left);
                if(temp.right != null) record.add(temp.right);
                if(i == length - 1) result.add(temp.val);
            }
        }
        return result;
    }
}