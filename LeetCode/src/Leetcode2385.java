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
    private int N = 100010;
    private int[] e = new int[2 * N];
    private int[] ne = new int[2 * N];
    private int[] h = new int[N];
    private int idx = 0;
    private int[] dist = new int[N];
    public int amountOfTime(TreeNode root, int start) {
        Arrays.fill(h, -1);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dfs(root);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        int result = 0;
        while(q.size() > 0) {
            int cur = q.poll();
            result = Math.max(result, dist[cur]);
            for(int i = h[cur]; i != -1; i = ne[i]) {
                int j = e[i];
                if(dist[j] > dist[cur] + 1) {
                    dist[j] = dist[cur] + 1;
                    q.add(j);
                }
            }
        }
        return result;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        if(root.left != null) {
            add(root.val, root.left.val);
            add(root.left.val, root.val);
            dfs(root.left);
        }
        if(root.right != null) {
            add(root.val, root.right.val);
            add(root.right.val, root.val);
            dfs(root.right);
        }
        return;
    }
    private void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }
}