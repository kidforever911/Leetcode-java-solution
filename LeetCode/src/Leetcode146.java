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

class LRUCache {
    private HashMap<Integer, Node> record = new HashMap<>();
    private int n;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    public LRUCache(int capacity) {
        n = capacity;
        head.right = tail;
        tail.left = head;
    }

    public int get(int key) {
        if(!record.containsKey(key)) return -1;
        Node temp = record.get(key);
        remove(temp);
        insert(temp);
        return temp.val;
    }

    public void put(int key, int value) {
        if(record.containsKey(key)){
            Node t = record.get(key);
            t.val = value;
            remove(t);
            insert(t);
        }else{
            if(record.size() == n){
                Node temp = tail.left;
                record.remove(temp.key);
                remove(temp);
            }
            Node newNode = new Node(key, value);
            record.put(key, newNode);
            insert(newNode);
        }

    }

    private void insert(Node node){
        node.right = head.right;
        node.left = head;
        head.right.left = node;
        head.right = node;
    }

    private void remove(Node node){
        node.left.right = node.right;
        node.right.left = node.left;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class Node {
    int key;
    int val;
    Node left;
    Node right;

    public Node() {
    }

    public Node(int key, int val) {
        this.key = key;
        this.val = v
    }
}


class LRUCache {
    private HashMap<Integer, Node> record = new HashMap<>();
    private int n;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    public LRUCache(int capacity) {
        n = capacity;
        head.right = tail;
        tail.left = head;
    }

    public int get(int key) {
        if(!record.containsKey(key)) return -1;
        Node theNode = record.get(key);
        remove(theNode);
        insert(theNode);
        return theNode.value;
    }

    public void put(int key, int value) {
        if(record.containsKey(key)) {
            Node theNode = record.get(key);
            theNode.value = value;
            remove(theNode);
            insert(theNode);
        } else {
            Node theNode = new Node(key, value);
            record.put(key, theNode);
            insert(theNode);
        }
        if(record.size() > n) {
            Node last = tail.left;
            remove(last);
            record.remove(last.key);
        }
    }

    private void insert(Node theNode) {
        theNode.right = head.right;
        theNode.left = head;
        head.right = theNode;
        theNode.right.left = theNode;
    }

    private void remove(Node theNode) {
        theNode.right.left = theNode.left;
        theNode.left.right = theNode.right;
    }
    class Node{
        int key;
        int value;
        Node left;
        Node right;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

class LRUCache {
    private Node head, tail;
    private HashMap<Integer, Node> record;
    private int n;
    public LRUCache(int capacity) {
        n = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        record = new HashMap<>();
        head.right = tail;
        tail.left = head;
    }

    public int get(int key) {
        if(!record.containsKey(key)) return -1;
        Node cur = record.get(key);
        remove(cur);
        insert(cur);
        return cur.value;
    }

    public void put(int key, int value) {
        if(record.containsKey(key)) {
            Node cur = record.get(key);
            cur.value = value;
            remove(cur);
            insert(cur);
        } else {
            Node cur = new Node(key, value);
            record.put(key, cur);
            insert(cur);
        }
        if(record.size() > n) {
            Node last = tail.left;
            remove(last);
            record.remove(last.key);
        }
    }

    private void insert(Node cur) {
        head.right.left = cur;
        cur.right = head.right;
        head.right = cur;
        cur.left = head;
    }
    private void remove(Node cur) {
        cur.left.right = cur.right;
        cur.right.left = cur.left;
    }

    class Node{
        int key;
        int value;
        Node left;
        Node right;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */