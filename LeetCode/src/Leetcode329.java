class Solution {
    private int row, col;
    private int[][] f;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        row = matrix.length;
        col = matrix[0].length;
        f = new int[row][col];
        for(int i = 0; i < row; i ++) {
            Arrays.fill(f[i], -1);
        }
        int result = 0;
        for(int i = 0; i < row; i ++) {
            for(int j = 0; j < col; j ++) {
                result = Math.max(result, dp(i, j, matrix));
            }
        }
        return result;
    }

    private int dp(int x, int y, int[][] matrix) {
        int num = f[x][y];
        if(num != -1) return num;
        f[x][y] = 1;
        for(int i = 0; i < 4; i ++) {
            int newx = x + direction[i][0];
            int newy = y + direction[i][1];
            if(inArea(newx, newy) && matrix[newx][newy] > matrix[x][y]) {
                f[x][y] = Math.max(f[x][y], dp(newx, newy, matrix) + 1);
            }
        }
        return f[x][y];
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}