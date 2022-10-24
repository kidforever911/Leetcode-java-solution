class Solution {
    public int jump(int[] nums) {
        if(nums.length == 0) return 0;
        int result = 0;
        int maxPosition = 0;
        int end = 0;
        for(int i = 0; i < nums.length - 1; i ++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if(i == end) {
                end = maxPosition;
                result ++;
            }
        }
        return result;
    }
}