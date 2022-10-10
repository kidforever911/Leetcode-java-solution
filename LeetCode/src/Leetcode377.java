class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int[] f = new int[target + 1];
        f[0] = 1;
        for(int j = 0; j <= target; j ++) {
            for(int x : nums) {
                if(j >= x) {
                    f[j] += f[j - x];
                }
            }
        }
        return f[target];
    }
}