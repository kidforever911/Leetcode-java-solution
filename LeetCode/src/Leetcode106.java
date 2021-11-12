import javax.swing.tree.TreeNode;
import java.util.HashMap;

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length || (inorder.length == 0 && postorder.length == 0)) return null;
        HashMap<Integer, Integer> record = new HashMap<>();
        for(int i = 0; i < inorder.length; i ++) record.put(inorder[i], i);
        return build(inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1, record);
    }

    private TreeNode build(int[] inorder, int[] postorder, int pl, int pr, int il, int ir, HashMap<Integer, Integer> record){
        if(pl > pr) return null;
        TreeNode root = new TreeNode(postorder[pr]);
        int k = record.get(postorder[pr]);
        root.right = build(inorder, postorder, pr - 1 - ir + k + 1, pr - 1, k + 1, ir, record);
        root.left = build(inorder, postorder, pl, pl + k - 1 - il, il, k - 1, record);
        return root;
    }
}