class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for(int i = 1; i <= n; i ++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        HashMap<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int result = 0;
        for(int i = 1; i <= n; i ++) {
            int r = (preSum[i] % k + k) % k;
            result += record.getOrDefault(r, 0);
            record.put(r, record.getOrDefault(r, 0) + 1);
        }
        return result;
    }
}