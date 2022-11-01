class Solution {
    public int destroyTargets(int[] nums, int space) {
        if(nums.length == 0) return 0;
        int result = 0;
        int count = 0;
        Arrays.sort(nums);
        HashMap<Integer, Integer> record = new HashMap<>();
        int n = nums.length;
        for(int i = n - 1; i >= 0; i --) {
            int temp = nums[i] % space;
            if(record.getOrDefault(temp, 0) >= count) {
                count = record.getOrDefault(temp, 0);
                result = nums[i];
            }
            record.put(temp, record.getOrDefault(temp, 0) + 1);
        }

        return result;
    }
}