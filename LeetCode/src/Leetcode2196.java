import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.HashSet;

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
    private int N = 10010;
    private int[] d = new int[N];
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> record = new HashMap<>();
        HashSet<Integer> child = new HashSet<>();
        for(int[] cur : descriptions){
            if(!record.containsKey(cur[0])){
                record.put(cur[0], new TreeNode(cur[0]));
            }
            if(!record.containsKey(cur[1])){
                record.put(cur[1], new TreeNode(cur[1]));
            }
            if(cur[2] == 1){
                record.get(cur[0]).left = record.get(cur[1]);
            }else{
                record.get(cur[0]).right = record.get(cur[1]);
            }
            child.add(cur[1]);
        }
        for(int[] cur : descriptions){
            if(!child.contains(cur[0])){
                return record.get(cur[0]);
            }
        }
        return null;
    }
}