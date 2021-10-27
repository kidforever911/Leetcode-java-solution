import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode47 {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            if(nums.length == 0) return result;
            LinkedList<Integer> record = new LinkedList<>();
            boolean[] used = new boolean[nums.length];
            generatePermutation(nums, 0, record, used, result);
            return result;
        }
        private void generatePermutation(int[] nums, int index, LinkedList<Integer> record,boolean[] used, List<List<Integer>> result){
            if(index == nums.length){
                result.add((LinkedList<Integer>)record.clone());
                return;
            }
            for(int i = 0; i < nums.length; i++){
                if(!used[i]){
                    if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                        continue;
                    }
                    used[i] = true;
                    record.addLast(nums[i]);
                    generatePermutation(nums, index + 1, record, used, result);
                    record.removeLast();
                    used[i] = false;
                }
            }
        }
    }
}
