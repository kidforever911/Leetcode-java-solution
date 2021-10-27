import java.util.HashMap;

public class Leetcode136 {
    class Solution {
        public int singleNumber(int[] nums) {
            HashMap<Integer, Integer> record = new HashMap<>();
            int result = 0;
            for(int i = 0; i < nums.length; i++){
                record.put(nums[i], record.getOrDefault(nums[i], 0) + 1);
            }
            for(int i = 0; i < nums.length; i++){
                if(record.get(nums[i]) < 2){
                    result = nums[i];
                }
            }
            return result;
        }
    }

    class Solution {
        public int singleNumber(int[] nums) {
            int result = 0;
            for(int i = 0; i < nums.length; i++){
                result ^= nums[i];
            }
            return result;
        }
    }
}
