class Solution {
    private int MOD = (int)1e9 + 7;
    private int N = 2010;
    public int numberOfWays(int startPos, int endPos, int k) {
        startPos += 500;
        endPos += 500;
        int[][] f = new int[k + 1][N];
        f[0][startPos] = 1;
        for(int i = 1; i <= k; i ++) {
            for(int j = 0; j < N; j ++) {
                if(j > 0) f[i][j] = f[i - 1][j - 1] % MOD;
                if(j + 1 < N) f[i][j] = (f[i][j] + f[i - 1][j + 1]) % MOD;
            }
        }
        return f[k][endPos];
    }
}