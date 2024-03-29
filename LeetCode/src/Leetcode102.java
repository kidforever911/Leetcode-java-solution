import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

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
            result.add(new ArrayList<>(list));
        }
        return result;
    }
}

class Solution {
    // Leetcode 102. Binary Tree Level Order Traversal
    // @爱学习的饲养员
    // DFS
    // N is the size of tree
    // H is the height of tree
    // Time Complexity: O(N)
    // Space Complexity: O(H)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) {
            return;
        }

        if (level > result.size() - 1) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);
        if (node.left != null) {
            dfs(node.left, result, level + 1);
        }
        if (node.right != null) {
            dfs(node.right, result, level + 1);
        }
    }
}

//用数组模拟队列
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        int N = 2010;
        TreeNode[] q = new TreeNode[N];
        int hh = 0, tt = 0;
        q[0] = root;
        while(tt >= hh){
            int length = tt - hh + 1;
            List<Integer> record = new ArrayList<>();
            for(int i = 0; i < length; i ++){
                TreeNode cur = q[hh ++];
                record.add(cur.val);
                if(cur.left != null){
                    q[++ tt] = cur.left;
                }
                if(cur.right != null){
                    q[++ tt] = cur.right;
                }
            }
            result.add(record);
        }
        return result;

    }
}

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()) {
            int len = q.size();
            List<Integer> record = new ArrayList<>();
            for(int i = 0; i < len; i ++) {
                TreeNode cur = q.poll();
                record.add(cur.val);
                if(cur.left != null) {
                    q.add(cur.left);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                }
            }
            result.add(record);
        }
        return result;
    }
}

