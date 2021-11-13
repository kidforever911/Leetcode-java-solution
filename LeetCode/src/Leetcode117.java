/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Node cur = root;
        while(cur != null){
            Node head = new Node();
            Node tail = head;
            for(Node temp = cur; temp != null; temp = temp.next){
                if(temp.left != null){
                    tail.next = temp.left;
                    tail = tail.next;
                }
                if(temp.right != null){
                    tail.next = temp.right;
                    tail = tail.next;
                }
            }
            cur = head.next;
        }
        return root;
    }
}