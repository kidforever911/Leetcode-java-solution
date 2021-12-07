/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode father;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode p) {
        if(p.right != null){
            p = p.right;
            while(p.left != null) p = p.left;
            return p;
        }
        while(p.father != null){
            if(p.father.right == p){
                p = p.father;
                continue;
            }
            return p.father;
        }
        return null;
    }
}