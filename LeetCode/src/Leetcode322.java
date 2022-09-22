class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] f = new int[amount + 1];
        int INF = 1000000;
        Arrays.fill(f, INF);
        f[0] = 0;
        for(int i = 1; i <= n; i ++) {
            for(int j = coins[i - 1]; j <= amount; j ++) {
                f[j] = Math.min(f[j], f[j - coins[i - 1]] + 1);
            }
        }
        return f[amount] == INF ? -1 : f[amount];
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];
        int INF = 1000000;
        for(int i = 0; i <= n; i ++) {
            for(int j = 0; j <= amount; j ++) {
                f[i][j] = INF;
            }
        }
        f[0][0] = 0;
        for(int i = 1; i <= n; i ++) {
            for(int j = 0; j <= amount; j ++) {
                f[i][j] = f[i - 1][j];
                if(j >= coins[i - 1]) {
                    f[i][j] = Math.min(f[i][j], f[i][j - coins[i - 1]] + 1);
                }
            }
        }
        return f[n][amount] == INF ? -1 : f[n][amount];
    }
}