import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */


class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        q.add(root);
        while (q.size() > 0) {
            int size = q.size();
            LinkedList<Integer> list = new LinkedList<>();
            level++;
            while (size > 0) {
                TreeNode cur = q.poll();
                if (level % 2 == 0) {
                    list.addFirst(cur.val);
                } else {
                    list.add(cur.val);
                }
                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
                size--;
            }
            result.add(list);
        }
        return result;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> record = new LinkedList<>();
        if(root != null) record.add(root);
        int level = 0;

        while(record.size() > 0){
            ArrayList<Integer> list = new ArrayList<>();
            int size = record.size();
            while(size > 0){
                TreeNode cur = record.poll();
                list.add(cur.val);
                if(cur.left != null)
                    record.add(cur.left);
                if(cur.right != null)
                    record.add(cur.right);
                size --;

            }
            if(++ level % 2 == 0) Collections.reverse(list);
            result.add(new ArrayList<>(list));
        }
        return result;
    }
}
