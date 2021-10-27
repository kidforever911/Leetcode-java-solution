import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode78 {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if(nums.length == 0) return result;
            LinkedList<Integer> record = new LinkedList<>();
            generateSubset(nums, 0, record, result);
            return result;
        }

        private void generateSubset(int[] nums, int index, LinkedList<Integer> record, List<List<Integer>> result){
            result.add((LinkedList<Integer>)record.clone());
            for(int i = index; i < nums.length; i++){
                record.addLast(nums[i]);
                generateSubset(nums, i + 1, record, result);
                record.removeLast();
            }
            return;
        }
    }
}
