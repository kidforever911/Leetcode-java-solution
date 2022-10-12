class Solution {
    public long countBadPairs(int[] nums) {
        if(nums.length < 2) return 0;
        int n = nums.length;
        long total = 1l * n * (n - 1) / 2;
        HashMap<Integer, Integer> record = new HashMap<>();
        for(int i = 0; i < n; i ++) {
            int temp = nums[i] - i;
            record.put(temp, record.getOrDefault(temp, 0) + 1);
        }
        for(int value : record.values()) {
            total -= 1l * value * (value - 1) / 2;
        }
        return total;
    }
}