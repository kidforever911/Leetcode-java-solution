class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int result = 0;
        for(int bit = 0; bit < 32; bit ++){
            int count = 0;
            for(int i = 0; i < n; i ++){
                if((nums[i] >> bit & 1) == 1) count ++;
            }
            if(count % 3 != 0) result += 1 << bit;
        }
        return result;
    }
}