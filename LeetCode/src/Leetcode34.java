class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if(nums.length == 0) return result;
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + right >> 1;
            if(nums[mid] >= target) right = mid;
            else left = mid + 1;
        }

        if(nums[right] != target) return result;
        result[0] = right;
        left = 0;
        right = nums.length - 1;
        while(left < right){
            int mid = left + right + 1 >> 1;
            if(nums[mid] <= target) left = mid;
            else right = mid - 1;
        }
        result[1] = left;
        return result;
    }
}