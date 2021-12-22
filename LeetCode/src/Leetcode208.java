class Trie {

    private TrieNode root;

    public class TrieNode{
        TrieNode[] next;
        boolean isEnd;

        public TrieNode(){
            next = new TrieNode[26];
            isEnd = false;
        }
    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(cur.next[index] == null) cur.next[index] = new TrieNode();
            cur = cur.next[index];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(cur.next[index] == null) return false;
            cur = cur.next[index];
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            int index = c - 'a';
            if(cur.next[index] == null) return false;
            cur = cur.next[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */