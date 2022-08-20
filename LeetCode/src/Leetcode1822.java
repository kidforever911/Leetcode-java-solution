class Solution {
    public int arraySign(int[] nums) {
        if(nums.length == 0) return 0;
        int count = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] == 0) return 0;
            if(nums[i] < 0) {
                count += 1;
            }
        }
        return count % 2 == 1 ? -1 : 1;
    }
}

class Solution {
    public int arraySign(int[] nums) {
        if(nums.length == 0) return 0;
        int sign = 1;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] == 0) return 0;
            if(nums[i] < 0) {
                sign = -sign;
            }
        }
        return sign;
    }
}