import java.util.Arrays;

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        word1 = ' ' + word1;
        word2 = ' ' + word2;
        int[][] f = new int[n + 1][m + 1];
        for(int[] rows : f){
            Arrays.fill(rows, Integer.MAX_VALUE);
        }

        if(n == 0 && m == 0) return 0;
        for(int i = 0; i <= n; i ++) f[i][0] = i;
        for(int i = 1; i <= m; i ++) f[0][i] = i;

        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= m; j ++){
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + 1;
                int t = (word1.charAt(i) != word2.charAt(j))? 1 : 0;
                f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + t);
            }
        }
        return f[n][m];
    }
}