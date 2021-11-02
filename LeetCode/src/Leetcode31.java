class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 0) return;
        int k = nums.length - 1;
        while(k > 0 && nums[k - 1] >= nums[k]) k --;
        if(k <= 0)
            reverse(nums, 0, nums.length - 1);
        else{
            int t = k;
            while(t < nums.length && nums[t] > nums[k - 1]) t++;
            swap(nums, t - 1, k - 1);
            reverse(nums, k, nums.length - 1);
        }
    }
    private void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int left, int right){
        while(left < right){
            swap(nums, left ++, right --);
        }
    }
}