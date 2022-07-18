/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private String path;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        path = "";
        dfs_s(root);
        return path;
    }
    private void dfs_s(TreeNode root) {
        if(root == null) path += "#,";
        else {
            path += Integer.toString(root.val) + ',';
            dfs_s(root.left);
            dfs_s(root.right);
        }
    }
    private int u;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        u = 0;
        return dfs_d(data);
    }
    private TreeNode dfs_d(String data) {
        if(data.charAt(u) == '#') {
            u += 2;
            return null;
        } else {
            int k = u;
            while(data.charAt(u) != ',') u ++;
            TreeNode root = new TreeNode(Integer.parseInt(data.substring(k, u)));
            u ++;
            root.left = dfs_d(data);
            root.right = dfs_d(data);
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));