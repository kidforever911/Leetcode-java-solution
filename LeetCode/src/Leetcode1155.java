class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int MOD = (int)(1e9 + 7);
        int[] f = new int[target + 1];
        f[0] = 1;
        for(int i = 1; i <= n; i ++) {
            for(int j = target; j >= 0; j --) {
                f[j] = 0;
                for(int m = 1; m <= k && m <= j; m ++) {
                    f[j] = (f[j] + f[j - m]) % MOD;
                }
            }
        }
        return f[target];
    }
}