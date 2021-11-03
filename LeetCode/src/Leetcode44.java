class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] f = new boolean[n + 1][m + 1];
        s = ' ' + s;
        p = ' ' + p;
        f[0][0] = true;

        for(int i = 0; i <= n; i ++){
            for(int j = 1; j <= m; j ++){
                if(p.charAt(j) == '*'){
                    f[i][j] = f[i][j - 1] || i > 0 && f[i - 1][j];
                }else{
                    f[i][j] = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') && i > 0 && f[i - 1][j - 1];
                }
            }
        }
        return f[n][m];
    }
}