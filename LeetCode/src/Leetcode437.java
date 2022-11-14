import javax.swing.tree.TreeNode;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int result = findPath(root, targetSum);
        result += pathSum(root.left, targetSum);
        result += pathSum(root.right, targetSum);
        return result;
    }

    private int findPath(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        if (root.val == sum) res += 1;
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;
    }
}

