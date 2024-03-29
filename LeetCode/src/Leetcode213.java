
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] robCurrent = new int[n + 1];
        int[] notRobCurrent = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            robCurrent[i] = notRobCurrent[i - 1] + nums[i - 1];
            notRobCurrent[i] = Math.max(robCurrent[i - 1], notRobCurrent[i - 1]);
        }
        int result = Math.max(robCurrent[n], notRobCurrent[n]);
        robCurrent[1] = nums[0];
        notRobCurrent[1] = 0;
        for (int i = 2; i <= n; i++) {
            robCurrent[i] = notRobCurrent[i - 1] + nums[i - 1];
            notRobCurrent[i] = Math.max(robCurrent[i - 1], notRobCurrent[i - 1]);
        }
        return Math.max(result, notRobCurrent[n]);
    }
}


class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] f = new int[n + 1];
        int[] g = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            f[i] = g[i - 1] + nums[i - 1];
            g[i] = Math.max(g[i - 1], f[i - 1]);
        }
        int result = Math.max(f[n], g[n]);
        f[1] = nums[0];
        g[1] = Integer.MIN_VALUE;
        for (int i = 2; i <= n; i++) {
            f[i] = g[i - 1] + nums[i - 1];
            g[i] = Math.max(g[i - 1], f[i - 1]);
        }
        return Math.max(result, g[n]);
    }
}

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob0(nums), rob1(nums));
    }

    public int rob0(int[] nums){
        int preMax = 0, curMax = 0;
        for(int i = 0; i < nums.length - 1; i++){
            int t = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = t;
        }
        return curMax;
    }

    public int rob1(int[] nums){
        int preMax = 0, curMax = 0;
        for(int i = 1; i < nums.length; i++){
            int t = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = t;
        }
        return curMax;
    }
}
