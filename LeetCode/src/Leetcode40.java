import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode40 {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            if(candidates.length == 0) return result;
            Arrays.sort(candidates);
            LinkedList<Integer> record = new LinkedList<>();
            generateCombination(candidates, target, 0, record, result);
            return result;
        }

        private void generateCombination(int[] candidates, int target, int starter, LinkedList<Integer> record, List<List<Integer>> result){
            if(target == 0){
                result.add((LinkedList<Integer>)record.clone());
                return;
            }
            for(int i = starter; i < candidates.length; i++){
                if(i > starter && candidates[i] == candidates[i - 1]){
                    continue;
                }
                if(target >= candidates[i]){
                    record.addLast(candidates[i]);
                    generateCombination(candidates, target - candidates[i], i + 1, record, result);
                    record.removeLast();
                }
            }
            return;
        }
    }
}
