class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + right >> 1;
            if(nums[mid] > nums[mid + 1]) right = mid;
            else left = mid + 1;
        }
        return right;
    }
}