import java.util.Arrays;

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int result = 0;
        Arrays.sort(nums);
        for(int i = 0; i + 2 < nums.length; i ++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < target){
                    result += right - left;
                    left ++;
                }else{
                    right --;
                }
            }
        }
        return result;
    }
}