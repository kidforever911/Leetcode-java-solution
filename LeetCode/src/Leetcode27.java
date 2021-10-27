public class Leetcode27 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int k = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != val){
                    swap(nums,k++,i);
                }
            }
            return k;

        }
        private void swap(int[] nums, int k, int i){
            int temp = nums[k];
            nums[k] = nums[i];
            nums[i] = temp;
        }
    }
}
