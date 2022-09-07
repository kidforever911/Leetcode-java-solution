class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int row1 = mat1.length;
        int col1 = mat1[0].length;
        int row2 = mat2.length;
        int col2 = mat2[0].length;
        int[][] result = new int[row1][col2];
        int index = 0;
        for(int i = 0; i < row1; i ++) {
            int sum = 0;
            for(int j = 0; j < col2; j ++) {
                while(index < col1) {
                    sum += mat1[i][index] * mat2[index][j];
                    index ++;
                }
                index = 0;
                result[i][j] = sum;
                sum = 0;
            }
        }
        return result;
    }
}