class MaxStack {
    private TreeMap<Integer, List<Node>> record;
    private Node head, tail;

    public MaxStack() {
        head = new Node(-1);
        tail = new Node(-1);
        record = new TreeMap<>(Collections.reverseOrder());
        head.right = tail;
        tail.left = head;
    }

    public void push(int x) {
        Node cur = new Node(x);
        if(!record.containsKey(x)) {
            record.put(x, new ArrayList<>());
        }
        record.get(x).add(cur);
        insert(cur);
    }

    public int pop() {
        int value = head.right.value;
        remove(head.right);
        record.get(value).remove(record.get(value).size() - 1);
        if(record.get(value).size() == 0) {
            record.remove(value);
        }
        return value;
    }

    public int top() {
        return head.right.value;
    }

    public int peekMax() {
        return record.firstKey();
    }

    public int popMax() {
        int value = record.firstKey();
        remove(record.get(value).remove(record.get(value).size() - 1));
        if(record.get(value).size() == 0) {
            record.remove(value);
        }
        return value;
    }

    private void insert(Node cur) {
        cur.right = head.right;
        head.right.left = cur;
        head.right = cur;
        cur.left = head;
    }

    private void remove(Node cur) {
        cur.left.right = cur.right;
        cur.right.left = cur.left;
    }

    class Node{
        int value;
        Node left;
        Node right;
        public Node(int val) {
            this.value = val;
            this.left = null;
            this.right = null;
        }
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */