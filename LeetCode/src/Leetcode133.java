/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.HashMap;

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> record = new HashMap<>();
        if(node == null) return node;
        dfs(node, record);

        for(Node key : record.keySet()){
            for(Node nei : key.neighbors){
                record.get(key).neighbors.add(record.get(nei));
            }
        }
        return record.get(node);
    }

    private void dfs(Node node, HashMap<Node, Node> record){
        record.put(node, new Node(node.val));
        for(Node nei : node.neighbors){
            if(!record.containsKey(nei)){
                dfs(nei, record);
            }
        }
        return;
    }
}