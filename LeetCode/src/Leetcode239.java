class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int[] q = new int[n + 1];
        int hh = 0, tt = -1;
        for(int i = 0; i < n; i ++){
            if(tt >= hh && i - k + 1 > q[hh]) hh ++;
            while(hh <= tt && nums[q[tt]] <= nums[i]) tt --;
            q[++ tt] = i;

            if(i >= k - 1) result[i - k + 1] = nums[q[hh]];
        }
        return result;
    }
}