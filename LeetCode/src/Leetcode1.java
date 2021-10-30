import java.util.HashMap;


//time complexity:o(n^2)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}

//time complexity:o(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums.length == 0) return result;
        HashMap<Integer, Integer> record = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            record.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i ++){
            if(record.containsKey(target - nums[i]) && record.get(target - nums[i]) != i){
                result[0] = i;
                result[1] = record.get(target - nums[i]);
            }
        }
        return result;
    }
}
