import java.util.Arrays;

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int[][] record = new int[m][n];
        for (int[] row : record) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) record[i][j] = grid[i][j];
                if (i > 0) record[i][j] = Math.min(record[i][j], grid[i][j] + record[i - 1][j]);
                if (j > 0) record[i][j] = Math.min(record[i][j], grid[i][j] + record[i][j - 1]);
            }
        }
        return record[m - 1][n - 1];
    }
}

class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (row == 0) return 0;
        int[][] record = new int[row + 1][col + 1];
        return calculateMinPath(grid, row - 1, col - 1, record);
    }

    private int calculateMinPath(int[][] grid, int row, int col, int[][] record) {
        if (row == 0 && col == 0) return grid[row][col];
        if (record[row][col] != 0) return record[row][col];
        if (row == 0) return record[row][col] = grid[row][col] + calculateMinPath(grid, row, col - 1, record);
        if (col == 0) return record[row][col] = grid[row][col] + calculateMinPath(grid, row - 1, col, record);
        return record[row][col] = grid[row][col] + Math.min(calculateMinPath(grid, row, col - 1, record), calculateMinPath(grid, row - 1, col, record));
    }
}


class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 || n == 0) return 0;
        int[][] f = new int[m][n];
        for (int[] row : f) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = grid[i][j];
                } else {
                    if (i > 0) f[i][j] = Math.min(f[i][j], f[i - 1][j] + grid[i][j]);
                    if (j > 0) f[i][j] = Math.min(f[i][j], f[i][j - 1] + grid[i][j]);
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
