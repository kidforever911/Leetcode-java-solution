import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    //dfs
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        pathSum(root, sum, res, new ArrayList<Integer>());
        return res;
    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp) {
        if (root == null) return;

        temp.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<Integer>(temp));
        } else {
            if (root.left != null) {
                pathSum(root.left, sum - root.val, res, temp);
            }
            if (root.right != null) {
                pathSum(root.right, sum - root.val, res, temp);
            }
        }
        temp.remove(temp.size() - 1);
    }
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        LinkedList<Integer> record = new LinkedList<>();
        generatePath(root, targetSum, record, result);
        return result;
    }

    private void generatePath(TreeNode root, int targetSum, LinkedList<Integer> record, List<List<Integer>> result){
        if(root == null) return;
        record.addLast(root.val);
        if(root.val == targetSum && root.left == null && root.right == null){
            result.add((LinkedList<Integer>)record.clone());
            return;
        }
        if(root.left != null){

            generatePath(root.left, targetSum - root.val, record, result);
            record.removeLast();
        }
        if(root.right != null){
            generatePath(root.right, targetSum - root.val, record, result);
            record.removeLast();
        }
        return;
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        List<Integer> record = new ArrayList<>();
        dfs(root, targetSum, record, result);
        return result;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> record, List<List<Integer>> result) {
        record.add(root.val);
        if(root.left == null && root.right == null && targetSum == root.val) {
            result.add(new ArrayList<>(record));
            return;
        }
        if(root == null) return;
        if(root.left != null) {
            dfs(root.left, targetSum - root.val, record, result);
            record.remove(record.size() - 1);
        }
        if(root.right != null) {
            dfs(root.right, targetSum - root.val, record, result);
            record.remove(record.size() - 1);
        }
        return;
    }
}
