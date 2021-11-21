import javax.swing.tree.TreeNode;
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
class BSTIterator {
    Stack<TreeNode> record = new Stack<>();

    public BSTIterator(TreeNode root) {
        while(root != null){
            record.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode root = record.peek();
        record.pop();
        int val = root.val;
        root = root.right;
        while(root != null){
            record.push(root);
            root = root.left;
        }
        return val;
    }

    public boolean hasNext() {
        return record.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */