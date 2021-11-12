import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;


//BFS iteration
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            depth++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = q.poll();
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return depth;

    }
}

//dfs recursive
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}



