import java.util.ArrayList;

public class Leetcode283 {
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    class Solution {
        public void moveZeroes(int[] nums) {
            ArrayList<Integer> nonZeroArray = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    nonZeroArray.add(nums[i]);
                }
            }
            for(int i = 0; i < nonZeroArray.size(); i++){
                nums[i] = nonZeroArray.get(i);
            }
            for(int i = nonZeroArray.size(); i < nums.length; i++){
                nums[i] = 0;
            }
        }
    }

    // 时间复杂度: O(n)
// 空间复杂度: O(1)
    class Solution {
        public void moveZeroes(int[] nums) {
            int nonZero = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    nums[nonZero] = nums[i];
                    nonZero++;
                }
            }
            for(int i = nonZero; i < nums.length; i++){
                nums[i] = 0;
            }
        }
    }


}
