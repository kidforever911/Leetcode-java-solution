class Solution {
    public int maxRotateFunction(int[] nums) {
        long cur = 0l;
        long sum = 0l;
        int n = nums.length;
        for(int x : nums) sum += (long)x;
        for(int i = 0; i < n; i ++) {
            cur += 1l * i * nums[i];
        }
        long result = cur;
        for(int i = n - 1; i >= 0; i --) {
            cur += sum - 1l * n * nums[i];
            result = Math.max(result, cur);
        }
        return (int) result;
    }
}