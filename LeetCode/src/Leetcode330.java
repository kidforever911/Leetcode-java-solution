class Solution {
    public int minPatches(int[] nums, int n) {
        long x = 1;
        int i = 0, result = 0;
        while(x <= n) {
            if(i < nums.length && nums[i] <= x) x += nums[i ++];
            else {
                x += x;
                result ++;
            }
        }
        return result;
    }
}