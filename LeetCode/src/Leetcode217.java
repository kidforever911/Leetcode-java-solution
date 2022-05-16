class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) return false;
        HashSet<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])) {
                return true;
            } else {
                record.add(nums[i]);
            }
        }
        return false;
    }
}