class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) return 0;
        int n = nums.length;
        int[] f = new int[n];
        int result = 0;
        for(int i = 2; i < n; i ++) {
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                f[i] = f[i - 1] + 1;
                result += f[i];
            }
        }
        return result;
    }
}