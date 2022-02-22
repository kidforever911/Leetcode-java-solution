import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        LinkedList<Integer> record = new LinkedList<>();
        generateSubset(nums, 0, record, result);
        return result;
    }

    private void generateSubset(int[] nums, int index, LinkedList<Integer> record, List<List<Integer>> result) {
        result.add((LinkedList<Integer>) record.clone());
        for (int i = index; i < nums.length; i++) {
            record.addLast(nums[i]);
            generateSubset(nums, i + 1, record, result);
            record.removeLast();
        }
        return;
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) return result;
        List<Integer> record = new ArrayList<>();
        dfs(0, nums, record, result);
        return result;
    }

    private void dfs(int index, int[] nums, List<Integer> record, List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<>(record));
            return;
        }

        //不选择当前这个数
        dfs(index + 1, nums, record, result);

        //选择当前这个数
        record.add(nums[index]);
        dfs(index + 1, nums, record, result);
        record.remove(record.size() - 1);
        return;
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) return result;
        int n = nums.length;
        for(int i = 0; i < (1 << n); i ++){
            List<Integer> record = new ArrayList<>();
            for(int j = 0; j < n; j ++){
                if((i >> j & 1) == 1){
                    record.add(nums[j]);
                }
            }
            result.add(record);
        }
        return result;
    }
}
