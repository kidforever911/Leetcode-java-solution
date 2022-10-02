class Solution {
    public int maxSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row - 2; i ++) {
            for(int j = 0; j < col - 2; j ++) {
                int sum = 0;
                sum = (grid[i][j] + grid[i][j + 1] + grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2]);
                result = Math.max(sum, result);
            }
        }
        return result;
    }
}