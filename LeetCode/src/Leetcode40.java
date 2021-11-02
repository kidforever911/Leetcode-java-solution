import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates.length == 0) return result;
        Arrays.sort(candidates);
        LinkedList record = new LinkedList<>();
        generateCombinations(candidates, 0, target, record, result);
        return result;
    }
    private void generateCombinations(int[] candidates, int index, int target, LinkedList<Integer> record, List<List<Integer>> result){
        if(target == 0){
            result.add((LinkedList<Integer>)record.clone());
            return;
        }
        if(target < 0)
            return;
        for(int i = index; i < candidates.length; i ++){
            if(i > index && candidates[i] == candidates[i - 1]) continue;
            if(candidates[i] <= target){
                record.addLast(candidates[i]);
                generateCombinations(candidates, i + 1, target - candidates[i], record, result);
                record.removeLast();
            }
        }
    }
}