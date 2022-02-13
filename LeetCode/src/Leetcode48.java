class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < i; j ++){
                swap(matrix, i, j, j, i);
            }
        }

        for(int i = 0; i < n; i ++){
            for(int j = 0, k = n - 1; j < k; j ++, k --){
                swap(matrix, i, j, i, k);
            }
        }


    }
    private void swap(int[][] matrix, int i, int j, int x, int y){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = temp;
    }
}

class Solution {
    public void rotate(int[][] matrix) {
        //沿着斜线对称
        swapDia(matrix);
        //沿着左右对称
        swapLR(matrix);
        return;
    }

    private void swapDia(int[][] matrix){
        for(int i = 0; i < matrix.length; i ++){
            for(int j = i; j < matrix.length; j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void swapLR(int[][] matrix){
        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0, k = matrix[0].length - 1; j < k; j ++, k --){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
    }
}