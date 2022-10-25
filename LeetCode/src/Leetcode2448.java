class Solution {
    public long minCost(int[] nums, int[] cost) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        long result = calculateCost(nums, cost, min);
        int left = min, right = max;
        while(left < right) {
            int mid = left + (right - left) / 2;
            long p1 = calculateCost(nums, cost, mid);
            long p2 = calculateCost(nums, cost, mid + 1);
            result = Math.min(p1, p2);
            if(p1 < p2) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private long calculateCost(int[] nums, int[] cost, int x) {
        long result = 0l;
        for(int i = 0; i < nums.length; i ++) {
            result += 1l * cost[i] * Math.abs(nums[i] - x);
        }
        return result;
    }
} 