import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


//iteration using queue
//time complexity:o
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        Queue<TreeNode> path = new LinkedList<TreeNode>();
        Queue<Integer> value = new LinkedList<Integer>();
        path.add(root);
        value.add(root.val);

        while (!path.isEmpty()) {
            TreeNode tempPath = path.poll();
            int tempVal = value.poll();
            if (tempPath.left == null && tempPath.right == null && tempVal == targetSum) {
                return true;
            } else {
                if (tempPath.left != null) {
                    path.add(tempPath.left);
                    value.add(tempVal + tempPath.left.val);
                }
                if (tempPath.right != null) {
                    path.add(tempPath.right);
                    value.add(tempVal + tempPath.right.val);
                }
            }

        }
        return false;
    }
}

//iteration using stack
//time complexity: o
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // iteration method
        if (root == null) {
            return false;
        }
        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sub = new Stack<>();
        path.push(root);
        sub.push(root.val);
        while (!path.isEmpty()) {
            TreeNode temp = path.pop();
            int tempVal = sub.pop();
            if (temp.left == null && temp.right == null) {
                if (tempVal == sum) return true;
            } else {
                if (temp.left != null) {
                    path.push(temp.left);
                    sub.push(temp.left.val + tempVal);
                }
                if (temp.right != null) {
                    path.push(temp.right);
                    sub.push(temp.right.val + tempVal);
                }
            }
        }
        return false;
    }
}

//recursive
//time complexity:o
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == targetSum)
            return true;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}


class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.val == targetSum && root.left == null && root.right == null) return true;
        if (root.left != null && hasPathSum(root.left, targetSum - root.val)) return true;
        if (root.right != null && hasPathSum(root.right, targetSum - root.val)) return true;
        return false;
    }
}
