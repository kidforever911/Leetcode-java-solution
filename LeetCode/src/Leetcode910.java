class Solution {
    public int smallestRangeII(int[] nums, int k) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int result = nums[n - 1] - nums[0];
        for(int i = 0; i + 1 < n; i ++) {
            int max = Math.max(nums[n - 1] - k, nums[i] + k);
            int min = Math.min(nums[0] + k, nums[i + 1] - k);
            result = Math.min(result, max - min);
        }
        return result;
    }
}