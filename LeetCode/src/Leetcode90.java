import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        Arrays.sort(nums);
        LinkedList<Integer> record = new LinkedList<>();
        generateSubsetWithDup(nums, 0, record, result);
        return result;
    }

    private void generateSubsetWithDup(int[] nums, int index, LinkedList<Integer> record, List<List<Integer>> result) {
        result.add((LinkedList<Integer>) record.clone());
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            record.addLast(nums[i]);
            generateSubsetWithDup(nums, i + 1, record, result);
            record.removeLast();
        }
        return;
    }
}

