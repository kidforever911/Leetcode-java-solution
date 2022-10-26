class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length == 0) return false;
        HashSet<Integer> record = new HashSet<>();
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for(int i = 1; i <= n; i ++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for(int i = 2; i <= n; i ++) {
            record.add(preSum[i - 2] % k);
            if(record.contains(preSum[i] % k)) {
                return true;
            }
        }
        return false;
    }
}