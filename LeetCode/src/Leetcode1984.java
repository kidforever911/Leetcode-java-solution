import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(nums.length == 0) return 0;
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int left = 0, right = left + k - 1; right < nums.length; left ++, right ++){
            result = Math.min(result, nums[right] - nums[left]);
        }
        return result;
    }
}