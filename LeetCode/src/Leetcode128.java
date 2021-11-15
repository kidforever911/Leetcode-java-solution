import java.util.HashSet;

//remove减少计算量，减小时间复杂度
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> record = new HashSet<>();
        for(int i = 0; i < nums.length; i ++){
            record.add(nums[i]);
        }
        int result = 0;
        for(int i = 0; i < nums.length; i ++){
            if(!record.contains(nums[i] - 1)){
                int x = nums[i];
                record.remove(x);
                while(record.contains(x + 1)){
                    x ++;
                    record.remove(x);
                }
                result = Math.max(result, x - nums[i] + 1);
            }
        }
        return result;
    }
}