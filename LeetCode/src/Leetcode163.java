class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int next = lower;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] < next) continue;
            if(nums[i] == next) {
                next = nums[i] + 1;
                continue;
            }
            result.add(getRange(next, nums[i] - 1));
            next = nums[i] + 1;
        }
        if(next <= upper) result.add(getRange(next, upper));
        return result;

    }

    private String getRange(int a, int b) {
        return a == b ? String.valueOf(a) : String.format("%d->%d", a, b);
    }
}