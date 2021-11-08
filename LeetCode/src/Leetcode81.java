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