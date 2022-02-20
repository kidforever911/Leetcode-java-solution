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


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int result = Integer.MAX_VALUE;
        int temp = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i + 2 < nums.length; i ++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];
                int diff = Math.abs(target - sum);
                if(sum == target){
                    return target;
                }else if(sum < target){
                    left ++;
                    if(temp > diff){
                        temp = diff;
                        result = sum;
                    }
                }else{
                    right --;
                    if(temp > diff){
                        temp = diff;
                        result = sum;
                    }
                }
            }
        }
        return result;
    }
}
