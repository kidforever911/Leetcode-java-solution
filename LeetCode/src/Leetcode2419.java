class Solution {
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int x : nums) {
            max = Math.max(x, max);
        }
        int result = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] == max) {
                int j = i;
                while(j < nums.length && nums[j] == max) j ++;
                result = Math.max(result, j - i);
                i = j - 1;
            }
        }
        return result;
    }
}