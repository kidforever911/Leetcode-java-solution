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

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> record = new HashMap<>();
        dfs(node, record);
        for(Node source : record.keySet()) {
            for(Node n : source.neighbors) {
                record.get(source).neighbors.add(record.get(n));
            }
        }
        return record.get(node);
    }

    private void dfs(Node node, HashMap<Node, Node> record) {
        if(node == null) return;
        record.put(node, new Node(node.val));
        for(Node temp : node.neighbors) {
            if(!record.containsKey(temp)) {
                dfs(temp, record);
            }
        }
        return;
    }
}