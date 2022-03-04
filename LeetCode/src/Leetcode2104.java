import java.util.ArrayDeque;
import java.util.Deque;

//暴力解法，时间复杂度n^2
class Solution {
    public long subArrayRanges(int[] nums) {
        if(nums.length == 0) return 0;
        long result = 0;
        for(int i = 0; i < nums.length; i ++){
            long min = nums[i];
            long max = nums[i];
            for(int j = i + 1; j < nums.length; j ++){
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                result += max - min;
            }
        }
        return result;
    }
}

//单调栈做法，但是用stack偏慢，可以用dequeue，时间复杂度n
class Solution {
    public long subArrayRanges(int[] nums) {
        if(nums.length == 0) return 0;
        long result = 0;
        long[] min = new long[nums.length];
        long[] max = new long[nums.length];
        min = getCount(nums, true);
        max = getCount(nums, false);
        for(int i = 0; i < nums.length; i ++){
            result += (max[i] - min[i]) * nums[i];
        }
        return result;
    }

    private long[] getCount(int[] nums, boolean isMin){
        long[] res = new long[nums.length];
        long[] left = new long[nums.length];
        long[] right = new long[nums.length];
        Deque<Integer> record = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i ++){
            while(record.size() > 0 && (isMin? nums[i] <= nums[record.peekLast()] : nums[i] >= nums[record.peekLast()])) record.pollLast();
            if(record.isEmpty()) left[i] = -1;
            else left[i] = record.peekLast();
            record.addLast(i);
        }
        record.clear();
        for(int i = nums.length - 1; i >= 0; i --){
            while(record.size() > 0 && (isMin? nums[i] < nums[record.peekLast()] : nums[i] > nums[record.peekLast()])) record.pollLast();
            if(record.isEmpty()) right[i] = nums.length;
            else right[i] = record.peekLast();
            record.addLast(i);
        }
        for(int i = 0; i < nums.length; i ++){
            res[i] = (right[i] - i) * (i - left[i]);
        }
        return res;

    }
}