class Solution {
    public boolean checkPossibility(int[] nums) {
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] < nums[i - 1]) {
                int a = nums[i];
                int b = nums[i - 1];
                nums[i] = nums[i - 1] = a;
                if(check(nums)) return true;
                nums[i] = nums[i - 1] = b;
                if(check(nums)) return true;
                return false;
            }
        }
        return true;
    }

    private boolean check(int[] nums) {
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}