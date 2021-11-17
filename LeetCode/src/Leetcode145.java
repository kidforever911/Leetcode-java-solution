import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }
    private void dfs(TreeNode root, List<Integer> result){
        if(root == null) return;
        dfs(root.left, result);
        dfs(root.right, result);
        result.add(root.val);
        return;
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null) return result;
        Stack<TreeNode> record = new Stack<>();
        while(root != null || record.size() != 0){
            while(root != null){
                result.addFirst(root.val);
                record.add(root);
                root = root.right;
            }
            root = record.pop().left;
        }
        return result;
    }
}