
class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                swap(nums, k++, i);
            }
        }
        return k;

    }

    private void swap(int[] nums, int k, int i) {
        int temp = nums[k];
        nums[k] = nums[i];
        nums[i] = temp;
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int slow = 0;
        int fast = 0;
        for(; fast < nums.length; fast ++){
            if(nums[fast] != val){
                nums[slow ++] = nums[fast];
            }
        }
        return slow;
    }
}

