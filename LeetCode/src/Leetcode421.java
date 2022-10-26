class Solution {
    public int findMaximumXOR(int[] nums) {
        if(nums.length == 0) return 0;
        Trie t = new Trie();
        int result = 0;
        for(int x : nums) {
            t.add(x);
        }
        for(int i : nums) {
            result = Math.max(result, t.query(i));
        }
        return result;
    }

    class Node{
        public Node[] children;

        public Node(){
            children = new Node[2];
        }
    }

    class Trie {
        Node head;

        public Trie(){
            head = new Node();
        }

        public void add(int num) {
            Node p = head;
            for(int i = 30; i >= 0; i --) {
                int v = num >> i & 1;
                if(p.children[v] == null) {
                    p.children[v] = new Node();
                }
                p = p.children[v];
            }
        }

        public int query(int num) {
            int result = 0;
            Node p = head;
            for(int i = 30; i >= 0; i --) {
                int v = num >> i & 1;
                if(p.children[1 ^ v] != null) {
                    result += 1 << i;
                    p = p.children[1 ^ v];
                } else {
                    p = p.children[v];
                }
            }
            return result;
        }
    }
}