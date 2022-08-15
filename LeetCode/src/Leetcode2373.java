class Solution {
    public int[][] largestLocal(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] result = new int[row - 2][col - 2];
        for(int i = 1; i < row - 1; i ++) {
            for(int j = 1; j < col - 1; j ++) {
                for(int x = i - 1; x <= i + 1; x ++) {
                    for(int y = j - 1; y <= j + 1; y ++) {
                        result[i - 1][j - 1] = Math.max(result[i - 1][j - 1], grid[x][y]);
                    }
                }
            }
        }
        return result;
    }
}