class Solution {
    public int getMoneyAmount(int n) {
        if(n == 0) return 0;
        int[][] f = new int[n + 2][n + 2];
        for(int len = 2; len <= n; len ++) {
            for(int i = 1; i + len - 1 <= n; i ++) {
                int j = i + len - 1;
                f[i][j] = Integer.MAX_VALUE;
                for(int k = i; k <= j; k ++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[i][k - 1], f[k + 1][j]) + k);
                }
            }
        }
        return f[1][n];
    }
}