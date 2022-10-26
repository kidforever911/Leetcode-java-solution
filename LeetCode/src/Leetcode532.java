import java.util.HashMap;

//twitter oa
class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums.length == 0) return 0;
        HashMap<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            record.put(nums[i], record.getOrDefault(nums[i], 0) + 1);
        }
        int result = 0;
        for (int i : record.keySet()) {
            int target = k + i;
            if ((k > 0 && record.containsKey(target)) || (k == 0 && record.get(target) > 1)) {
                result++;
            }
        }
        return result;
    }
}

