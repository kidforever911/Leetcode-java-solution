import javax.swing.tree.TreeNode;
import java.util.*;

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        LinkedList<ArrayList<Integer>> temp = new LinkedList<>();

        while (q.size() > 0) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = q.size();
            while (size > 0) {
                TreeNode cur = q.poll();
                list.add(cur.val);
                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
                size--;
            }
            temp.addFirst(new ArrayList<>(list));
        }
        result = new ArrayList<>(temp);
        return result;
    }
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> record = new LinkedList<>();
        if(root != null) record.add(root);

        while(record.size() > 0){
            int size = record.size();
            List<Integer> list = new ArrayList<>();
            while(size > 0){
                TreeNode cur = record.poll();
                list.add(cur.val);
                if(cur.left != null)
                    record.add(cur.left);
                if(cur.right != null)
                    record.add(cur.right);
                size --;
            }
            result.add(new ArrayList<>(list));
        }
        Collections.reverse(result);
        return result;
    }
}

