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
//递归写法，时间复杂度o(m)
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, result);
        return result;
    }

    private void dfs(Node root, List<Integer> result){
        if(root == null) return;
        result.add(root.val);
        for(Node cur : root.children){
            dfs(cur, result);
        }
        return;

    }
}

//缺一个迭代写法