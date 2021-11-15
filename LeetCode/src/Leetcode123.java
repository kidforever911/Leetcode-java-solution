//前后缀分解法
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int n = prices.length;
        int[] f = new int[n + 1];
        for(int i = 1, min = Integer.MAX_VALUE; i <= n; i ++){
            f[i] = Math.max(f[i - 1], prices[i - 1] - min);
            min = Math.min(min, prices[i - 1]);
        }

        int result = 0;
        for(int i = n, max = 0; i > 0; i --){
            result = Math.max(result, max - prices[i - 1] + f[i - 1]);
            max = Math.max(max, prices[i - 1]);
        }
        return result;
    }
}