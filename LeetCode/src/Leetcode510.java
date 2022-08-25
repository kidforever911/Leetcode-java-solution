/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if(node == null) return null;
        if(node.right != null) {
            Node temp = node.right;
            while(temp.left != null) {
                temp = temp.left;
            }
            return temp;
        } else {
            while(node.parent != null && node.parent.left != node) {
                node = node.parent;
            }
            return node.parent;
        }
    }
}