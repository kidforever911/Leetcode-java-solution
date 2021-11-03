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