class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if(s3.length() != m + n) return false;
        boolean[][] f = new boolean[n + 1][m + 1];
        s1 = ' ' + s1;
        s2 = ' ' + s2;
        s3 = ' ' + s3;
        for(int i = 0; i <= n; i ++){
            for(int j = 0; j <= m; j ++){
                if(i == 0 && j == 0) f[i][j] = true;
                else{
                    if(i > 0 && s1.charAt(i) == s3.charAt(i + j)) f[i][j] = f[i][j] || f[i - 1][j];
                    if(j > 0 && s2.charAt(j) == s3.charAt(i + j)) f[i][j] = f[i][j] || f[i][j - 1];
                }
            }
        }
        return f[n][m];
    }
}