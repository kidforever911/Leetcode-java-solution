class Solution {
    public int maximumTop(int[] nums, int k) {
        if(nums.length == 1 && k % 2 == 1 && k >= nums.length) return -1;
        int result = Integer.MIN_VALUE;
        if(nums.length > k){
            result = Math.max(nums[k], result);
            for(int i = 0; i < k - 1; i ++){
                result = Math.max(nums[i], result);
            }
        }else if(nums.length == k){
            for(int i = 0; i < k - 1; i ++){
                result = Math.max(nums[i], result);
            }
        }else{
            for(int i = 0; i < nums.length; i ++){
                result = Math.max(nums[i], result);
            }
        }
        return result;
    }
}