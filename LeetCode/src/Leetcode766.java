class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        boolean result = true;
        for(int i = 0; i < matrix.length; i ++) {
            for(int j = 0; j < matrix[0].length; j ++) {
                int temp = matrix[i][j];
                int x = i;
                int y = j;
                while(inArea(x, y, matrix)) {
                    x += 1;
                    y += 1;
                    if(inArea(x, y, matrix) && matrix[x][y] != temp) {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }
    private boolean inArea(int x, int y, int[][] matrix) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }
}

