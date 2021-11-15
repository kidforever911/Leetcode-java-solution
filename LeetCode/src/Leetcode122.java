class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int result = 0;
        for(int i = 0; i + 1 < prices.length; i ++){
            result += Math.max(0, prices[i + 1] - prices[i]);
        }
        return result;
    }
}