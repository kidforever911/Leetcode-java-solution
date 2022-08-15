class Solution {
    private int MOD = (int)(1e9 + 7);
    public int knightDialer(int n) {
        //f表示走n步到0-9的可能次数
        int[][] f = new int[n][10];
        for(int i = 0; i < 10; i ++) f[0][i] = 1;
        int[][] tr = {
                {4, 6},
                {6, 8},
                {7, 9},
                {4, 8},
                {3, 9, 0},
                {},
                {1, 7, 0},
                {2, 6},
                {1, 3},
                {2, 4}
        };
        for(int i = 1; i < n; i ++){
            for(int j = 0;  j < 10; j ++) {
                for(int k : tr[j]) {
                    f[i][j] = (f[i][j] + f[i - 1][k]) % MOD;
                }
            }
        }
        int result = 0;
        for(int i = 0; i < 10; i ++) {
            result = (result + f[n - 1][i]) % MOD;
        }
        return result;
    }
}