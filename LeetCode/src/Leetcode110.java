import javax.swing.tree.TreeNode;


class Solution {
    int max = Integer.MAX_VALUE;

    public boolean isBalanced(TreeNode root) {
        int result = balance(root);
        if (result == max)
            return false;
        return true;
    }

    private int balance(TreeNode root) {
        if (root == null) return 0;
        int left = balance(root.left);
        int right = balance(root.right);
        if (left == max || right == max) return max;
        if (Math.abs(left - right) > 1) {
            return max;
        }
        return Math.max(left, right) + 1;
    }
}

class Solution {
    private boolean result;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        result = true;
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(Math.abs(left - right) > 1) result = false;
        return Math.max(left, right) + 1;
    }
}

