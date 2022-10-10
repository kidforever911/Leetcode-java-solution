class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int MOD = (int)(1e9 + 7);
        int[][][] f = new int[row + 1][col + 1][k];
        f[1][1][grid[0][0] % k] = 1;
        for(int i = 1; i <= row; i ++) {
            for(int j = 1; j <= col; j ++) {
                if(i == 1 && j == 1) continue;
                for(int r = 0; r < k; r ++) {
                    f[i][j][(r + grid[i - 1][j - 1]) % k] = (f[i][j - 1][r] + f[i - 1][j][r]) % MOD;
                }
            }
        }
        return f[row][col][0];
    }
}