class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int INT_MIN = Integer.MIN_VALUE;
        int[][] f = new int[m + 1][m + 1];
        f[0][0] = 0;
        for(int i = 1; i <= m; i ++) {
            for(int j = 0; j <= i; j ++) {
                f[i][j] = INT_MIN;
                int p = multipliers[i - 1];
                if(j >= 1) f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + p * nums[j - 1]);
                if(i - j >= 1) f[i][j] = Math.max(f[i][j], f[i - 1][j] + p * nums[n - (i - j)]);
            }
        }
        int result = INT_MIN;
        for(int i = 0; i <= m; i ++) {
            result = Math.max(result, f[m][i]);
        }
        return result;
    }
}