import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Leetcode257 {
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            if(root == null) return result;
            if(root.left == null && root.right == null)
                result.add(Integer.toString(root.val));
            List<String> leftPath = binaryTreePaths(root.left);
            for(String s : leftPath){
                StringBuilder sb = new StringBuilder(Integer.toString(root.val));
                sb.append("->");
                sb.append(s);
                result.add(sb.toString());
            }
            List<String> rightPath = binaryTreePaths(root.right);
            for(String s : rightPath){
                StringBuilder sb = new StringBuilder(Integer.toString(root.val));
                sb.append("->");
                sb.append(s);
                result.add(sb.toString());
            }
            return result;
        }
    }
}
