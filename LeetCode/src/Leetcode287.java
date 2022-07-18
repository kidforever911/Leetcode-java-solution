class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length == 0) return 0;
        int left = 1, right = nums.length - 1;
        while(left < right){
            int mid = left +  right >> 1;
            int count = 0;
            for(int x : nums){
                if(x <= mid && x >= left){
                    count += 1;
                }
            }
            if(count > mid - left + 1) right = mid;
            else left= mid + 1;
        }
        return right;
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) {
                slow = 0;
                while(slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
    }
}