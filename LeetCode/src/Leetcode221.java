class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] f = new int[row + 1][col + 1];
        int result = 0;
        for(int i = 1; i <= row; i ++){
            for(int j = 1; j <= col; j ++){
                if(matrix[i - 1][j - 1] == '1'){
                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
                    result = Math.max(result, f[i][j]);
                }
            }
        }
        return result * result;
    }
}