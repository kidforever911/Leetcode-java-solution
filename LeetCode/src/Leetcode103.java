import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode103 {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root == null) return result;
            Queue<TreeNode> q = new LinkedList<>();
            int level = 0;
            q.add(root);
            while(q.size() > 0){
                int size = q.size();
                LinkedList<Integer> list = new LinkedList<>();
                level++;
                while(size > 0){
                    TreeNode cur = q.poll();
                    if(level % 2 == 0){
                        list.addFirst(cur.val);
                    }else{
                        list.add(cur.val);
                    }
                    if(cur.left != null)
                        q.add(cur.left);
                    if(cur.right != null)
                        q.add(cur.right);
                    size--;
                }
                result.add(list);
            }
            return result;
        }
    }
}
