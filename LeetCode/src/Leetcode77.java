import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class kSolution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) return result;
        LinkedList<Integer> record = new LinkedList<>();
        generateCombination(n, k, 1, record, result);
        return result;
    }

    private void generateCombination(int n, int k, int start, LinkedList<Integer> record, List<List<Integer>> result) {
        if (record.size() == k) {
            result.add((LinkedList<Integer>) record.clone());
            return;
        }
        for (int i = start; i <= n; i++) {
            record.addLast(i);
            generateCombination(n, k, i + 1, record, result);
            record.removeLast();
        }
        return;
    }
}

//剪枝法
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) return result;
        LinkedList<Integer> record = new LinkedList<>();
        generateCombination(n, k, 1, record, result);
        return result;
    }

    private void generateCombination(int n, int k, int start, LinkedList<Integer> record, List<List<Integer>> result) {
        if (record.size() == k) {
            result.add((LinkedList<Integer>) record.clone());
            return;
        }
        //还有k - record.size()个空位，所以[1...n]中至少还有k-record.size()个元素
        //i最多为n - (k - record.size()) + 1
        for (int i = start; i <= n - (k - record.size()) + 1; i++) {
            record.addLast(i);
            generateCombination(n, k, i + 1, record, result);
            record.removeLast();
        }
        return;
    }
}

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(n == 0 || k == 0) return result;
        LinkedList<Integer> record = new LinkedList<>();
        generateCombination(n, k, 1, record, result);
        return result;
    }
    //从index位置的数开始选，选k个数
    private void generateCombination(int n, int k, int index, LinkedList<Integer> record, List<List<Integer>> result){
        if(k == 0){
            result.add((LinkedList<Integer>)record.clone());
            return;
        }

        for(int i = index; i <= n; i ++){
            record.addLast(i);
            generateCombination(n, k - 1, i + 1, record, result);
            record.removeLast();
        }
        return;
    }
}


class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> record = new ArrayList<>();
        dfs(n, k, 0, 1, record, result);
        return result;
    }

    private void dfs(int n, int k, int index, int cur, List<Integer> record, List<List<Integer>> result) {
        if(index == k) {
            result.add(new ArrayList<>(record));
            return;
        }

        for(int i = cur; i <= n - (k - index) + 1; i ++) {
            record.add(i);
            dfs(n, k, index + 1, i + 1, record, result);
            record.remove(record.size() - 1);
        }
        return;
    }
}
