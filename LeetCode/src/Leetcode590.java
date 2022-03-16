/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, result);
        return result;
    }

    private void dfs(Node root, List<Integer> result){
        if(root == null) return;
        for(Node cur : root.children){
            dfs(cur, result);

        }
        result.add(root.val);
        return;
    }
}