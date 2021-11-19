class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int left  = 0, right = n - 1;
        if(nums[right] > nums[left] || right == 0) return nums[0];
        while(left < right){
            int mid = left + right + 1 >> 1;
            if(nums[mid] >= nums[0]) left = mid;
            else right = mid - 1;
        }
        return nums[left + 1];
    }
}

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int left  = 0, right = n - 1;
        if(nums[right] > nums[left] || right == 0) return nums[0];
        while(left < right){
            int mid = left + right >> 1;
            if(nums[mid] < nums[0]) right = mid;
            else left = mid + 1;
        }
        return nums[right];
    }
}