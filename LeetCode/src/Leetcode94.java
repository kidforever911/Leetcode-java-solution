import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode94 {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            if(root == null) return result;
            Stack<TreeNode> record = new Stack<>();
            TreeNode cur = root;
            while(!record.isEmpty() || cur != null){
                while(cur != null){
                    record.push(cur);
                    cur = cur.left;
                }
                cur = record.pop();
                result.add(cur.val);
                cur = cur.right;
            }
            return result;
        }

    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            inorder(root, result);
            return result;
        }

        private void inorder(TreeNode root, List<Integer> result){
            if(root != null){
                if(root.left != null) inorder(root.left, result);
                result.add(root.val);
                if(root.right != null) inorder(root.right, result);
            }

        }
    }
}
