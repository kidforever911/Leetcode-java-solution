class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int result = nums[0];
        int f = nums[0], g = nums[0];
        for(int i = 1; i < nums.length; i ++){
            int a = nums[i], fa = f * a, ga = g * a;
            f = Math.max(a, Math.max(fa, ga));
            g = Math.min(a, Math.min(fa, ga));
            result = Math.max(result, f);
        }
        return result;
    }
}