class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] result = new int[2];
        HashSet<Integer> record = new HashSet<>();
        for(int i = 0; i < n; i ++) {
            if(record.contains(nums[i])) {
                result[0] = nums[i];
            }
            record.add(nums[i]);
        }
        for(int i = 1; i <= n; i ++) {
            if(!record.contains(i)) {
                result[1] = i;
            }
        }
        return result;
    }
}