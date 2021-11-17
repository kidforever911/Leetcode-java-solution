import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//recursive
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            preorder(root.left, result);
            preorder(root.right, result);
        }
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Stack<TreeNode> record = new Stack<>();
        record.push(root);
        while (!record.isEmpty()) {
            TreeNode visiting = record.pop();
            result.add(visiting.val);
            if (visiting.right != null) record.push(visiting.right);
            if (visiting.left != null) record.push(visiting.left);
        }
        return result;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result){
        if(root == null) return;
        result.add(root.val);
        dfs(root.left, result);
        dfs(root.right, result);
        return;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> record = new Stack<>();
        while(root != null || record.size() != 0){
            while(root != null){
                result.add(root.val);
                record.push(root);
                root = root.left;
            }
            root = record.pop().right;
        }
        return result;
    }

}
