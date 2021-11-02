import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) return result;
        LinkedList<Integer> record = new LinkedList<>();
        generateCombination(candidates, target, 0, record, result);
        return result;
    }

    private void generateCombination(int[] candidates, int target, int index, LinkedList<Integer> record, List<List<Integer>> result) {
        if (target == 0) {
            result.add((LinkedList<Integer>) record.clone());
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                record.addLast(candidates[i]);
                generateCombination(candidates, target - candidates[i], i, record, result);
                record.removeLast();
            }
        }
    }
}
