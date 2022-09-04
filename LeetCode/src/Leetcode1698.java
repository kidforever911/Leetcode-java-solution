class Solution {
    public int countDistinct(String s) {
        int result = 0;
        Node root = new Node();
        for(int i = 0; i < s.length(); i ++) {
            Node cur = root;
            for(int j = i; j < s.length(); j ++) {
                if(cur.child[s.charAt(j) - 'a'] == null) {
                    cur.child[s.charAt(j) - 'a'] = new Node();
                    result ++;
                }
                cur = cur.child[s.charAt(j) - 'a'];
            }
        }
        return result;
    }

    class Node {
        Node[] child = new Node[26];
    }
}