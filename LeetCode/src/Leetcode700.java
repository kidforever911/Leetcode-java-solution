import javax.swing.tree.TreeNode;

public class Leetcode700 {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if(root == null) return null;
            if(root.val == val) return root;
            return val < root.val? searchBST(root.left, val) : searchBST(root.right, val);
        }
    }

    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            while(root != null && root.val != val){
                root = val < root.val? root.left : root.right;
            }
            return root;
        }
    }
}
