import java.util.Arrays;

class Solution {
    static int N = 30010, idx = 0;
    static int[][] tree = new int[N][26];
    static boolean[] isEnd = new boolean[N];
    public String longestWord(String[] words) {
        if(words.length == 0) return "";
        Arrays.fill(isEnd, false);
        for (int i = 0; i <= idx; i++) Arrays.fill(tree[i], 0);
        idx = 0;
        for(String s : words){
            add(s);
        }
        int length = 0;
        String result = "";
        for(String s : words){
            if(query(s)){
                if(s.length() > length){
                    length = s.length();
                    result = s;
                }else if(s.length() == length){
                    result = result.compareTo(s) > 0? s : result;
                }
            }
        }
        return result;
    }
    private void add(String s){
        int k = 0;
        for(int i = 0; i < s.length(); i ++){
            int u = s.charAt(i) - 'a';
            if(tree[k][u] == 0) tree[k][u] = ++idx;
            k = tree[k][u];
        }
        isEnd[k] = true;
    }

    private boolean query(String s){
        int k = 0;
        for(int i = 0; i < s.length(); i ++){
            int u = s.charAt(i) - 'a';
            k = tree[k][u];
            if(!isEnd[k]) return false;
        }
        return true;
    }
}