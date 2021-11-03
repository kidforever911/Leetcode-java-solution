import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) return result;
        Arrays.sort(nums);
        LinkedList<Integer> record = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        generatePermutationUnique(nums, 0, used, record, result);
        return result;
    }

    private void generatePermutationUnique(int[] nums, int index, boolean[] used, LinkedList<Integer> record, List<List<Integer>> result){
        if(index == nums.length){
            result.add((LinkedList<Integer>)record.clone());
            return;
        }
        for(int i = 0; i < nums.length; i ++){

            if(!used[i]){
                //如果i-1被用过，直接continue，防止前一个相同的元素被复用
                if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                record.addLast(nums[i]);
                generatePermutationUnique(nums, index + 1, used, record, result);
                record.removeLast();
                used[i] = false;
            }
        }
        return;
    }
}