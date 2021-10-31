import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) return result;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i ++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[left] + nums[right] == - nums[i]){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left ++;
                    right --;
                    while(left < right && nums[left] == nums[left - 1])
                        left ++;
                    while(left < right && nums[right] == nums[right + 1])
                        right --;
                }
                else if(nums[left] + nums[right] < - nums[i])
                    left ++;
                else
                    right --;
            }
        }
        return result;
    }
}

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> answer = new ArrayList<>();
            if(nums.length == 0) return answer;
            HashMap<Integer, Integer> record = new HashMap<>();
            Arrays.sort(nums);
            for(int i = 0; i < nums.length; i++){
                record.put(nums[i], i);
            }

            for(int i = 0; i + 2 < nums.length; i++){
                for(int j = i + 1; j + 1 < nums.length; j++){
                    int target = 0 - nums[i] - nums[j];
                    if(record.containsKey(target) && record.get(target) > j){
                        answer.add(Arrays.asList(nums[i], nums[j], nums[record.get(target)]));
                        j = record.get(nums[j]);
                    }
                    i = record.get(nums[i]);
                }
            }
            return answer;
        }
    }


}
