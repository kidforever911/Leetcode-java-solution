class Solution {
    private int result;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        result = Integer.MAX_VALUE;
        for(int i = 0; i < baseCosts.length; i ++) {
            dfs(baseCosts[i], toppingCosts, target, 0);
        }
        return result;
    }

    private void dfs(int cost, int[] toppingCosts, int target, int index) {
        if(result >= target && cost >= result) {
            return;
        }
        if(index == toppingCosts.length) {
            if(Math.abs(result - target) > Math.abs(cost - target)) {
                result = cost;
            } else if(Math.abs(result - target) == Math.abs(cost - target)) {
                result = Math.min(result, cost);
            }
            return;
        }

        for(int i = 0; i <= 2; i ++) {
            dfs(cost + i * toppingCosts[index], toppingCosts, target, index + 1);
        }
    }
}