class NumArray {
    private int[] tr;
    private int[] arr;

    private int lowbit(int x) {
        return x & (-x);
    }

    private void add(int x, int c) {
        for(int i = x; i <= arr.length; i += lowbit(i)) tr[i] += c;
    }

    private int query(int x) {
        int res = 0;
        for(int i = x; i > 0; i -= lowbit(i)) res += tr[i];
        return res;
    }

    public NumArray(int[] nums) {
        tr = new int[nums.length + 1];
        this.arr = nums;
        for(int i = 1; i <= nums.length; i ++) add(i, nums[i - 1]);
    }

    public void update(int index, int val) {
        add(index + 1, val - arr[index]);
        arr[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */