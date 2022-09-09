/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> record = new HashMap<>();
        Node cur = head;
        copyValue(cur, record);
        for(Map.Entry<Node, Node> entry: record.entrySet()) {
            Node a = entry.getKey();
            Node b = entry.getValue();
            b.next = record.get(a.next);
            b.random = record.get(a.random);
        }
        return record.get(head);
    }

    private void copyValue(Node cur, HashMap<Node, Node> record) {
        while(cur != null) {
            record.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        return;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> record = new HashMap<>();
        Node cur = head;
        dfs(cur, record);
        for(Map.Entry<Node, Node> entry: record.entrySet()) {
            Node a = entry.getKey();
            Node b = entry.getValue();
            b.next = record.get(a.next);
            b.random = record.get(a.random);
        }
        return record.get(head);
    }

    private void dfs(Node cur, HashMap<Node, Node> record) {
        if(cur == null) return;
        record.put(cur, new Node(cur.val));
        if(cur != null) {
            dfs(cur.next, record);
        }
        return;
    }
}