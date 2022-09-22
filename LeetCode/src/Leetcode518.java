class Solution {
    public int change(int amount, int[] coins) {
        int[] f = new int[amount + 1];
        f[0] = 1;
        for(int i = 0; i < coins.length; i ++) {
            for(int j = coins[i]; j <= amount; j ++) {
                f[j] += f[j - coins[i]];
            }
        }
        return f[amount];
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];
        f[0][0] = 1;
        for(int i = 1; i <= n; i ++) {
            for(int j = 0; j <= amount; j ++) {
                f[i][j] = f[i - 1][j];
                if(j >= coins[i - 1]) f[i][j] += f[i][j - coins[i - 1]];
            }
        }
        return f[n][amount];
    }
}