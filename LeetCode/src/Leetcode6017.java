import java.util.Arrays;

class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long start = 1;
        long count = 0;
        long result = 0;
        for(int i = 0; i < nums.length && k > 0; i ++){
            if(nums[i] > start){
                count = (nums[i] - start) > k ? k : nums[i] - start;
                k -= count;
                result += (start + start + count - 1) * count / 2;
            }
            start = nums[i] + 1;
        }
        if(k > 0){
            result += (start + start + k - 1) * k / 2;
        }
        return result;
    }
}