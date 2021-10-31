class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        s = ' ' + s;
        p = ' ' + p;
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for(int i = 0; i <= n; i ++){
            for(int j = 1; j <= m; j ++){
                if(j + 1 <= m && p.charAt(j + 1) == '*') continue;
                if(i > 0 && p.charAt(j) != '*'){
                    f[i][j] = f[i - 1][j - 1] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                }else if(p.charAt(j) == '*'){
                    f[i][j] = f[i][j - 2] || i > 0 && f[i - 1][j] && (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
            }
        }
        return f[n][m];
    }
}
