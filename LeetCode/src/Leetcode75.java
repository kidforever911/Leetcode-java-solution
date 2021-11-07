class Solution {
    public void sortColors(int[] nums) {
        for(int i = 0, j = 0, k = nums.length - 1; i <= k;){
            if(nums[i] == 0) swap(nums, i ++, j ++);
            else if(nums[i] == 2) swap(nums, i, k --);
            else i ++;
        }
        return;
    }

    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}