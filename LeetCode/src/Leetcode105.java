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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length || (preorder.length == 0 && inorder.length == 0)) return null;
        HashMap<Integer, Integer> record = new HashMap<>();
        for(int i = 0; i < inorder.length; i ++) record.put(inorder[i], i);
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, record);
    }

    private TreeNode build(int[] preorder, int[] inorder, int pl, int pr, int il, int ir, HashMap<Integer, Integer> record){
        if(pl > pr) return null;
        TreeNode root = new TreeNode(preorder[pl]);
        int k = record.get(root.val);
        root.left = build(preorder, inorder, pl + 1, pl + 1 + k - 1 - il, il, k - 1, record);
        root.right = build(preorder, inorder, pl + 1 + k - 1 - il + 1, pr, k + 1, ir, record);
        return root;
    }
}