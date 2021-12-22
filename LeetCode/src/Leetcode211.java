class WordDictionary {

    private TrieNode root;

    public class TrieNode{
        TrieNode[] next;
        boolean isEnd;

        public TrieNode(){
            next = new TrieNode[26];
            isEnd = false;
        }
    }

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(cur.next[index] == null) cur.next[index] = new TrieNode();
            cur = cur.next[index];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, TrieNode root, int index){
        if(index == word.length()) return root.isEnd;
        if(word.charAt(index) != '.'){
            int u = word.charAt(index) - 'a';
            if(root.next[u] != null && dfs(word, root.next[u], index + 1))
                return true;
            return false;
        }else{
            for(int i = 0; i < 26; i ++){
                if(root.next[i] != null && dfs(word, root.next[i], index + 1))
                    return true;
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */