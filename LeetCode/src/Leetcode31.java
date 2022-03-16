class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 0) return;
        //找到从后往前第一个降序结束的下标
        int index = nums.length - 1;
        while(index > 0 && nums[index - 1] >= nums[index]) index --;
        if(index <= 0){
            reverse(nums, 0, nums.length - 1);
        }else{
            //找到比从后往前第一个降序结束的下标值对应数值大一点的数的下标
            int t = index;
            while(t < nums.length && nums[t] > nums[index - 1]) t ++;
            swap(nums, index - 1, t - 1);
            reverse(nums, index, nums.length - 1);
        }
    }

    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    private void reverse(int[] nums, int left, int right){
        while(left < right){
            swap(nums, left ++, right --);
        }
    }
}