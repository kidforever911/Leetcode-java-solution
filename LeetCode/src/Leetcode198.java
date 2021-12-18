import java.util.Arrays;


class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        // record[i] 表示考虑抢劫 nums[i...n) 所能获得的最大收益
        int[] record = new int[nums.length];
        Arrays.fill(record, -1);
        return tryRob(nums, 0, record);
    }

    // 考虑抢劫nums[index...nums.size())这个范围的所有房子
    private int tryRob(int[] nums, int index, int[] record) {
        if (index >= nums.length) return 0;
        if (record[index] != -1) return record[index];
        int result = -1;
        for (int i = index; i < nums.length; i++) {
            result = Math.max(result, nums[i] + tryRob(nums, i + 2, record));
        }
        record[index] = result;
        return result;
    }
}

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int[] record = new int[n];
        record[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                record[i] = Math.max(record[i], nums[j] + (j + 2 < n ? record[j + 2] : 0));
            }
        }
        return record[0];
    }
}

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] f = new int[n];
        f[0] = nums[0];
        f[1] = Math.max(nums[1], nums[0]);
        for(int i = 2; i < n; i ++){
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i]);
        }
        return f[n - 1];
    }
}

