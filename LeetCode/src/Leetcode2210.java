class Solution {
    public int countHillValley(int[] nums) {
        if(nums.length == 0) return 0;
        int result = 0;
        for(int i = 1; i < nums.length - 1; i ++){
            if(nums[i] == nums[i + 1]) continue;
            int left = i - 1, right = i + 1;
            while(left > 0 && nums[left] == nums[i]) left --;
            while(right < nums.length - 1 && nums[right] == nums[i]) right ++;
            if(nums[i] > nums[left] && nums[i] > nums[right]) result ++;
            if(nums[i] < nums[left] && nums[i] < nums[right]) result ++;

        }
        return result;
    }
}