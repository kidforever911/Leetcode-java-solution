class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        for(int x : nums){
            if(x == target)
                return true;
        }
        return false;
    }
}

class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int n = nums.length - 1;
        int t = n;
        while(t > 0 && nums[t] == nums[0]) t --;
        if(t == 0) return nums[0] == target;
        if(nums[t] > nums[0]) return check(nums, target, 0, t);
        int right = t, left = 0;
        while(left < right) {
            int mid = left + right >> 1;
            if(nums[mid] < nums[0]) right = mid;
            else left = mid + 1;
        }
        if(target > nums[t]) {
            left = 0;
            right -= 1;
        }
        else right = t;
        return check(nums, target, left, right);
    }

    private boolean check(int[] nums, int target, int left, int right) {
        while(left < right) {
            int mid = left + right >> 1;
            if(nums[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return nums[right] == target;
    }
}