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

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Node> record = new ArrayDeque<>();
        record.add(root);
        while(!record.isEmpty()){
            int length = record.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < length; i ++) {
                Node cur = record.poll();
                temp.add(cur.val);
                if(cur.children.size() > 0) {
                    for(int j = 0; j < cur.children.size(); j ++) {
                        record.add(cur.children.get(j));
                    }
                }
            }
            result.add(temp);
        }
        return result;
    }
}