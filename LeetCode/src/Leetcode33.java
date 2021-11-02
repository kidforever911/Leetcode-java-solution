class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + right + 1 >> 1;
            if(nums[mid] >= nums[0]) left = mid;
            else right = mid - 1;
        }

        if(target >= nums[0]) left = 0;
        else{
            left = right + 1;
            right = nums.length - 1;
        }
        while(left < right){
            int mid = left + right >> 1;
            if (nums[mid] >= target) right = mid;
            else left = mid + 1;
        }
        if(nums[right] == target) return right;
        return -1;
    }
}