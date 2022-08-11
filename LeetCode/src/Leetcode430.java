/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node[] result = dfs(head);
        return result[0];
    }

    private Node[] dfs(Node head) {
        if(head == null) return new Node[]{null, null};
        Node cur = head;
        Node tail = head;
        while(cur != null) {
            tail = cur;
            if(cur.child != null) {
                Node[] t = dfs(cur.child);
                cur.child = null;
                t[1].next = cur.next;
                if(cur.next != null) cur.next.prev = t[1];
                cur.next = t[0];
                t[0].prev = cur;
                cur = t[1].next;
                tail = t[1];
            }else{
                cur = cur.next;
            }
        }
        return new Node[]{head, tail};
    }
}