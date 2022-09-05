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
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        HashMap<Integer, List<Node>> record = new HashMap<>();
        dfs(root, record, 0, 0);
        for(int i = min; i <= max; i ++) {
            if(!record.containsKey(i)) continue;
            List<Node> cur = record.get(i);
            Collections.sort(cur, (a, b) -> (a.row == b.row ? (a.val - b.val) : (a.row - b.row)));
            List<Integer> temp = new ArrayList<>();
            for(Node c : cur) {
                temp.add(c.val);
            }
            result.add(temp);
        }
        return result;
    }

    private void dfs(TreeNode root, HashMap<Integer, List<Node>> record, int index, int row) {
        if(root == null) return;
        min = Math.min(min, index);
        max = Math.max(max, index);
        List<Node> cur = record.getOrDefault(index, new ArrayList<>());
        cur.add(new Node(root.val, row));
        record.put(index, cur);
        if(root.left != null) {
            dfs(root.left, record, index - 1, row + 1);
        }
        if(root.right != null) {
            dfs(root.right, record, index + 1, row + 1);
        }
        return;
    }
    class Node {
        int val;
        int row;
        public Node(int val, int row) {
            this.val = val;
            this.row = row;
        }
    }
}