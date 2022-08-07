class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int n = prices.length;
        int[][] f = new int[n][3];
        for(int i = 0; i < n; i ++) {
            Arrays.fill(f[i], Integer.MIN_VALUE);
        }
        f[0][1] = -prices[0];
        f[0][0] = 0;;
        for(int i = 1; i < n; i ++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2]);
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - prices[i]);
            f[i][2] = f[i - 1][1] + prices[i];
        }
        return Math.max(f[n - 1][0], Math.max(f[n - 1][1], f[n - 1][2]));
    }
}