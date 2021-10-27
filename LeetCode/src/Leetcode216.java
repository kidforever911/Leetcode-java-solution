import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode216 {
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new ArrayList<>();
            if(k >= n) return result;
            LinkedList<Integer> record = new LinkedList<>();
            generateCombination(k, n, 1, record, result);
            return result;
        }

        private void generateCombination(int k, int n, int index, LinkedList<Integer> record, List<List<Integer>> result){
            if(n == 0 && k == 0){
                result.add((LinkedList<Integer>)record.clone());
                return;
            }
            for(int i = index; i <= n; i++){
                if(n >= i && k > 0 && i <= 9){
                    record.addLast(i);
                    generateCombination(k - 1, n - i, i + 1, record, result);
                    record.removeLast();
                }
            }
            return;
        }
    }
}
