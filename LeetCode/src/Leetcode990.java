class Solution {
    private int[] p;
    public boolean equationsPossible(String[] equations) {
        p = new int[26];
        for(int i = 0; i < 26; i ++) p[i] = i;
        for(String e : equations) {
            int x = e.charAt(0) - 'a';
            int y = e.charAt(3) - 'a';
            if(e.charAt(1) == '=') {
                p[find(x)] = find(y);
            }
        }
        for(String e : equations) {
            int x = e.charAt(0) - 'a';
            int y = e.charAt(3) - 'a';
            if(e.charAt(1) == '!') {
                if(find(x) == find(y))
                    return false;
            }
        }
        return true;
    }

    private int find(int x) {
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}