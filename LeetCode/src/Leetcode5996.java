class Solution {
    public int countPairs(int[] nums, int k) {
        if(nums.length == 0) return 0;
        int result = 0;
        for(int i = 0; i + 1 < nums.length; i ++){
            for(int j = i + 1; j < nums.length; j ++){
                if(nums[i] == nums[j] && ((i * j) % k == 0)){
                    result += 1;
                }
            }
        }
        return result;
    }
}