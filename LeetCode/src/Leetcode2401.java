class Solution {
    public int longestNiceSubarray(int[] nums) {
        if(nums.length == 0) return 0;
        int[] count = new int[40];
        int result = 0;
        for(int slow = 0, fast = 0, total = 0; fast < nums.length; fast ++) {
            for(int k = 0; k < count.length; k ++) {
                if((nums[fast] >> k & 1) == 1) {
                    count[k] ++;
                    if(count[k] > 1) {
                        total ++;
                    }
                }
            }
            while(total > 0) {
                for(int k = 0; k < count.length; k ++) {
                    if((nums[slow] >> k & 1) == 1) {
                        count[k] --;
                        if(count[k] == 1) {
                            total --;
                        }
                    }
                }
                slow ++;
            }
            result = Math.max(result, fast - slow + 1);
        }
        return result;
    }
}