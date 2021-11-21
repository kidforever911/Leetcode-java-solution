class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 0) return 0;
        int nowSave = nums[0], nowNumber = 1;
        for(int i = 1; i < nums.length; i ++){
            if(nowSave == nums[i]) nowNumber ++;
            if(nowSave != nums[i] && nowNumber > 0) nowNumber --;
            if(nowSave != nums[i] && nowNumber == 0){
                nowSave = nums[i];
                nowNumber = 1;
            }
        }
        return nowSave;
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 0) return 0;
        int nowSave = 0, nowNumber = 0;
        for(int x : nums){
            if(nowNumber == 0){
                nowSave = x;
                nowNumber ++;
            }else if(nowSave == x) nowNumber ++;
            else nowNumber --;
        }
        return nowSave;
    }
}