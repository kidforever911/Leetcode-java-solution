//错误写法
//交换过程可能把负数交换到前面，导致没法返回-1
class Solution {
    public int duplicateInArray(int[] nums) {
        if(nums.length == 0) return -1;
        int n = nums.length;
        int result = -1;
        for(int i  = 0; i < n; i ++){
            if(nums[i] < 0 || nums[i] >= n) return -1;
            if(i != nums[i] && nums[i] == nums[nums[i]]) result = nums[i];
            else swap(nums, i, nums[i]);
        }
        return result;
    }
    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
        return;
    }
}

//正确写法
class Solution {
    public int duplicateInArray(int[] nums) {
        if(nums.length == 0) return -1;
        int n = nums.length;
        for(int i = 0; i< n; i ++){
            if(nums[i] < 0 || nums[i] >= n) return -1;
        }
        int result = -1;
        for(int i  = 0; i < n; i ++){
            if(i != nums[i] && nums[i] == nums[nums[i]]) return nums[i];
            else swap(nums, i, nums[i]);
        }
        return -1;
    }
    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
        return;
    }
}