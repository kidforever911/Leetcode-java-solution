import javax.swing.tree.TreeNode;

public class Leetcode450 {
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null) return null;
            if(key > root.val){
                root.right = deleteNode(root.right, key);
            }else if(key < root.val){
                root.left = deleteNode(root.left, key);
            }else{
                if(root.left == null)
                    return root.right;
                if(root.right == null)
                    return root.left;
                int minVal = findMin(root.right);
                root.val = minVal;
                root.right = deleteNode(root.right, minVal);
            }
            return root;
        }

        private int findMin(TreeNode node){
            while(node.left != null){
                node = node.left;
            }
            return node.val;
        }
    }
}
