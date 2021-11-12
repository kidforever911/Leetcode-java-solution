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

