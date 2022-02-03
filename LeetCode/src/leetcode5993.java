import java.util.HashSet;

class Solution {
    public int findFinalValue(int[] nums, int original) {
        if(nums.length == 0) return 0;
        HashSet<Integer> record = new HashSet<>();
        for(int i = 0; i < nums.length; i ++){
            record.add(nums[i]);
        }
        while(record.contains(original)){
            original *= 2;
        }
        return original;
    }
}