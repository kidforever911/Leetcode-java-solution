class NumArray {
    private int[] s;

    public NumArray(int[] nums) {
        s = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i ++) {
            s[i] = s[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        ++ left;
        ++ right;
        return s[right] - s[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */