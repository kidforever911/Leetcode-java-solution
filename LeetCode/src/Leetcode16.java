import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i ++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if(Math.abs(result - target) > Math.abs(sum - target))
                    result = sum;
                if(sum == target)
                    return target;
                else if(sum > target)
                    right -- ;
                else
                    left ++;
            }
        }
        return result;
    }
}
