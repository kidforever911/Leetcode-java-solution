import java.util.HashMap;

class LRUCache {
    class Node{
        int key;
        int value;
        Node left;
        Node right;
        Node(){}
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    HashMap<Integer, Node> record = new HashMap<>();
    int n;

    public LRUCache(int capacity) {
        n = capacity;
        head.right = tail;
        tail.left = head;
    }

    public int get(int key) {
        if(!record.containsKey(key)) return -1;
        Node node = record.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(record.containsKey(key)){
            Node node = record.get(key);
            node.value = value;
            remove(node);
            insert(node);
        }else{
            Node node = new Node(key, value);
            if(record.size() == n){
                Node last = tail.left;
                remove(last);
                record.remove(last.key);
            }
            insert(node);
            record.put(key, node);
        }
    }

    private void remove(Node node){
        node.left.right = node.right;
        node.right.left = node.left;
    }

    private void insert(Node node){
        node.right = head.right;
        node.left = head;
        node.right.left = node;
        node.left.right = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */