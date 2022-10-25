import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length == 0) return false;
        int sum = 0;
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        int[][] record = new int[nums.length][sum / 2 + 1];
        for(int[] row : record){
            Arrays.fill(row, -1);
        }
        return tryPartition(nums, nums.length - 1, sum / 2, record);
    }

    private boolean tryPartition(int[] nums, int index, int sum, int[][] record){
        if(sum == 0) return true;
        if(sum < 0 || index < 0) return false;
        if(record[index][sum] != -1) return record[index][sum] == 1;

        record[index][sum] = (tryPartition(nums, index - 1, sum, record) || tryPartition(nums, index - 1, sum - nums[index], record)) ? 1 : 0;
        return record[index][sum] == 1;
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums) sum += x;
        if(sum % 2 != 0) return false;
        sum /= 2;
        int[] f = new int[sum + 1];
        f[0] = 1;
        for(int i = 1; i <= n; i ++) {
            for(int j = sum; j >= nums[i - 1]; j --) {
                f[j] |= f[j - nums[i - 1]];
            }
        }
        return f[sum] > 0;
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums) sum += x;
        if(sum % 2 != 0) return false;
        sum /= 2;
        int[] f = new int[sum + 1];
        f[0] = 1;
        for(int i = 1; i <= n; i ++) {
            for(int j = sum; j >= nums[i - 1]; j --) {
                f[j] = Math.max(f[j], f[j - nums[i - 1]]);
            }
        }
        return f[sum] > 0;
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums) sum += x;
        if(sum % 2 != 0) return false;
        sum /= 2;
        int[][] f = new int[n + 1][sum + 1];
        f[0][0] = 1;
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= sum; j ++) {
                f[i][j] = f[i - 1][j];
                if(j >= nums[i - 1]) f[i][j] = Math.max(f[i][j], f[i - 1][j - nums[i - 1]]);
            }
        }
        return f[n][sum] > 0;
    }
}
