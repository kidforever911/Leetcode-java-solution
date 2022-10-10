import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        List<Integer> record = new ArrayList<>();
        dfs(root, record);
        int left = 0, right = record.size() - 1;
        while(left < right){
            int sum = record.get(left) + record.get(right);
            if(sum > k){
                right --;
            }else if(sum < k){
                left ++;
            }else{
                return true;
            }
        }
        return false;
    }

    private void dfs(TreeNode root, List<Integer> record){
        if(root == null) return;
        if(root.left != null) dfs(root.left, record);
        record.add(root.val);
        if(root.right != null) dfs(root.right, record);
        return;
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> record = new ArrayList<>();
        dfs(root, record);
        for(int i = 0, j = record.size() - 1; i < j; ) {
            int sum = record.get(i) + record.get(j);
            if(sum == k) return true;
            else if(sum < k) i ++;
            else j --;
        }
        return false;
    }
    private void dfs(TreeNode root, List<Integer> record) {
        if(root == null) return;
        if(root.left != null) dfs(root.left, record);
        record.add(root.val);
        if(root.right != null) dfs(root.right, record);
    }
}