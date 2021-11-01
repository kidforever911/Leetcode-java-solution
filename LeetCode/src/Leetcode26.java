class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int slow = 0;
        int fast = 0;
        for(; fast < nums.length; fast ++){
            if(fast == 0 || nums[fast] != nums[fast - 1])
                nums[slow ++] = nums[fast];
        }
        return slow;
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = 0;
        if (nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[n]) {
                swap(nums, ++n, i);

            }
        }
        return n + 1;
    }

    private void swap(int[] nums, int n, int i) {
        int temp = nums[n];
        nums[n] = nums[i];
        nums[i] = temp;
    }

}
