class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left < right && nums[right] == nums[0]) right --;
        if(nums[left] <= nums[right]) return nums[0];
        while(left < right){
            int mid = left + right >> 1;
            if(nums[mid] < nums[0]) right = mid;
            else left = mid + 1;
        }
        return nums[left];
    }
}