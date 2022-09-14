class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int result = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i ++){
            min = Math.min(min, prices[i]);
            result = Math.max(result, prices[i] - min);
        }
        return result;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0; i < prices.length; i ++) {
            result = Math.max(result, prices[i] - min);
            if(prices[i] < min) {
                min = prices[i];
            }
        }
        return result;
    }
}