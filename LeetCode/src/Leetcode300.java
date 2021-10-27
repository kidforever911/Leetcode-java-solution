import java.util.Arrays;
import java.util.LinkedList;

public class Leetcode300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if(nums.length == 0) return 0;
            int[] record = new int[nums.length];
            Arrays.fill(record, 1);
            for(int i = 1; i < nums.length; i ++){
                for(int j = 0; j < i; j ++){
                    if(nums[i] > nums[j]){
                        record[i] = Math.max(record[i], 1 + record[j]);
                    }
                }
            }
            int result = record[0];
            for(int i = 0; i < nums.length; i ++){
                result = Math.max(result, record[i]);
            }
            return result;
        }
    }

    class Solution {
        public int lengthOfLIS(int[] nums) {
            if(nums.length == 0) return 0;
            int[] record = new int[nums.length];
            Arrays.fill(record, -1);
            int result = 1;
            for(int i = 1; i < nums.length; i ++){
                result = Math.max(result, getMaxLength(nums, i, record));
            }
            return result;
        }

        private int getMaxLength(int[] nums, int index, int[] record){
            if(record[index] != -1)
                return record[index];

            int result = 1;
            for(int i = 0; i < index; i ++){
                if(nums[index] > nums[i]){
                    result = Math.max(result, 1 + getMaxLength(nums, i, record));
                }
            }
            return record[index] = result;
        }
    }

    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            LinkedList<Integer> tail = new LinkedList<>();
            for(int x : nums){
                if(tail.isEmpty() || x > tail.getLast()) tail.addLast(x);
                else{
                    if(x <= tail.get(0)) tail.set(0, x);
                    else{
                        int left = 0, right = tail.size() - 1;
                        while(left < right){
                            int mid = left + right + 1 >> 1;
                            if(tail.get(mid) < x) left = mid;
                            else right = mid - 1;
                        }
                        tail.set(right + 1, x);
                    }
                }
            }
            return tail.size();
        }
    }
}
