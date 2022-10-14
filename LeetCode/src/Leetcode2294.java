class Solution {
    public int partitionArray(int[] nums, int k) {
        if(nums.length == 0) return 0;
        int result = 0;
        Arrays.sort(nums);
        int slow = 0, fast = 0;
        for(; fast < nums.length; fast ++) {
            if(nums[fast] - nums[slow] > k) {
                result ++;
                slow = fast;
            }
        }
        if(slow < nums.length) result ++;
        return result;
    }
}