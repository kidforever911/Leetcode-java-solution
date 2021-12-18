class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return;
        int n = nums.length;
        k = k % n;
        swap(nums, 0, n - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, n - 1);
        return;
    }

    private void swap(int[] nums, int left, int right){
        for(int i = left, j = right; i < j; i ++, j --){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return;
    }
}