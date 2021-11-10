import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Stack<TreeNode> record = new Stack<>();
        TreeNode cur = root;
        while (!record.isEmpty() || cur != null) {
            while (cur != null) {
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

    private void inorder(TreeNode root, List<Integer> result) {
        if (root != null) {
            if (root.left != null) inorder(root.left, result);
            result.add(root.val);
            if (root.right != null) inorder(root.right, result);
        }

    }
}


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result) {
        if (root == null) return;
        dfs(root.left, result);
        result.add(root.val);
        dfs(root.right, result);
        return;
    }

}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> record = new Stack<>();
        while(root != null || record.size() != 0){
            while(root != null){
                record.push(root);
                root = root.left;
            }
            if(record.size() != 0){
                root = record.peek();
                record.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
}
