import javax.swing.tree.TreeNode;


class Solution {
    private int counter = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        counter = k;
        helper(root);
        return result;
    }

    private void helper(TreeNode root) {
        if (root.left != null) {
            helper(root.left);
        }
        counter--;
        if (counter == 0)
            result = root.val;
        if (root.right != null)
            helper(root.right);

    }
}


class Solution {
    private int result;
    private int counter;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        counter = k;
        dfs(root);
        return result;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        if(root.left != null){
            dfs(root.left);
        }
        if(-- counter == 0){
            result = root.val;
        }
        if(root.right != null){
            dfs(root.right);
        }
        return;
    }
}

