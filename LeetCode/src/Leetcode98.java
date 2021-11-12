import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;


class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        boolean left = isBST(root.left, min, root.val);
        boolean right = isBST(root.right, root.val, max);
        return left && right;
    }
}



class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return dfs(root)[0] == 1;
    }

    private int[] dfs(TreeNode root){
        int[] result = {1, root.val, root.val};
        if(root.left != null){
            int[] t = dfs(root.left);
            //如果左子树最大值大于根节点则false
            if(t[0] == 0 || t[2] >= root.val) result[0] = 0;
            /*
            更新左子树的最小值和最大值，也可以是：
            result[1] = t[1];
            result[2] = result[2];
            */
            result[1] = Math.min(result[1], t[1]);
            result[2] = Math.max(result[2], t[2]);
        }

        if(root.right != null){
            int[] t = dfs(root.right);
            //如果右子树最小值小于根节点则false
            if(t[0] == 0 || t[1] <= root.val) result[0] = 0;
            /*
            更新右子树的最小值最大值，也可以是：
            result[1] = result[1];
            result[2] = t[2];
            */
            result[1] = Math.min(result[1], t[1]);
            result[2] = Math.max(result[2], t[2]);
        }
        return result;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root, result);
        for(int i = 0; i < result.size(); i ++){
            if(i > 0 && result.get(i) <= result.get(i - 1))
                return false;
        }
        return true;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left, result);
        result.add(root.val);
        inOrderTraversal(root.right, result);
        return;
    }
}
