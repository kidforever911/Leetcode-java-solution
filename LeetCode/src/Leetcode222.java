import javax.swing.tree.TreeNode;


class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null)
            return 1;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        int sum = left + right + 1;
        return sum;
    }
}

class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        int l = 1, r = 1;
        while(leftNode != null){
            leftNode = leftNode.left;
            l ++;
        }
        while(rightNode != null){
            rightNode = rightNode.right;
            r ++;
        }
        if(l == r) return (1 << l) - 1;
        return countNodes(root.left) + 1 + countNodes(root.right);
    }
}
