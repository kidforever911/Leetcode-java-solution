import java.util.ArrayList;

public class Leetcode26 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            ArrayList<Integer> nonDup = new ArrayList<>();
            int n = 0;
            if(nums.length == 0) return 0;
            nonDup.add(nums[0]);
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != nums[n]){
                    n = i;
                    nonDup.add(nums[n]);
                }
            }
            for(int i = 0; i < nonDup.size(); i++){
                nums[i] = nonDup.get(i);

            }
            int k = nonDup.size();
            return k;
        }
    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            int n = 0;
            if(nums.length == 0) return 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != nums[n]){
                    swap(nums, ++n, i);

                }
            }
            return n + 1;
        }
        private void swap(int[] nums, int n, int i){
            int temp = nums[n];
            nums[n] = nums[i];
            nums[i] = temp;
        }

    }
}
