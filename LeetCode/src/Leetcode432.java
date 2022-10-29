class AllOne {
    private Node left, right;
    private HashMap<String, Node> record;

    public AllOne() {
        left = new Node(Integer.MIN_VALUE);
        right = new Node(Integer.MAX_VALUE);
        left.right = right;
        right.left = left;
        record = new HashMap<>();
    }

    public void inc(String key) {
        if(!record.containsKey(key)) record.put(key, addToRight(left, key, 1));
        else {
            Node t = record.get(key);
            t.set.remove(key);
            record.put(key, addToRight(t, key, t.val + 1));
            if(t.set.isEmpty()) remove(t);
        }
    }

    public void dec(String key) {
        if(!record.containsKey(key)) return;
        else {
            Node t = record.get(key);
            t.set.remove(key);
            if(t.val > 1) {
                record.put(key, addToLeft(t, key, t.val - 1));
            } else {
                record.remove(key);
            }
            if(t.set.isEmpty()) remove(t);
        }
    }

    private Node addToLeft(Node node, String key, int val) {
        if(node.left.val == val) node.left.set.add(key);
        else {
            Node t = new Node(val);
            t.set.add(key);
            t.left = node.left;
            node.left.right = t;
            t.right = node;
            node.left = t;
        }
        return node.left;
    }

    private Node addToRight(Node node, String key, int val) {
        if(node.right.val == val) node.right.set.add(key);
        else {
            Node t = new Node(val);
            t.set.add(key);
            t.right = node.right;
            node.right.left = t;
            t.left = node;
            node.right = t;
        }
        return node.right;
    }

    public String getMaxKey() {
        if(right.left != left) return right.left.set.iterator().next();
        else return "";
    }

    public String getMinKey() {
        if(left.right != right) return left.right.set.iterator().next();
        else return "";
    }

    private void remove(Node t) {
        t.left.right  = t.right;
        t.right.left = t.left;
    }


    class Node {
        Node left;
        Node right;
        int val;
        HashSet<String> set;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.set = new HashSet<>();
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */