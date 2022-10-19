class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0;
        int smin = 0;
        int smax = 0;
        for(int fast = 0, last = 0, slow = 0; fast < nums.length; fast ++) {
            if(nums[fast] < minK || nums[fast] > maxK) {
                last = slow = fast + 1;
                smin = smax = 0;
                continue;
            }
            if(nums[fast] == minK) smin ++;
            if(nums[fast] == maxK) smax ++;
            while(slow <= fast) {
                if(nums[slow] == minK) smin --;
                if(nums[slow] == maxK) smax --;
                if(smin == 0 || smax == 0) {
                    if(nums[slow] == minK) smin ++;
                    if(nums[slow] == maxK) smax ++;
                    break;
                }
                slow ++;
            }
            if(smin > 0 && smax > 0) {
                result += 1l + slow - last;
            }
        }
        return result;
    }
}