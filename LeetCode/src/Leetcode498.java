class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[] result = new int[row * col];
        int index = 0;
        for(int i = 0; i < row + col - 1; i ++) {
            if(i % 2 == 0) {
                for(int j = Math.min(row - 1, i); j >= Math.max(0, 1 - col + i); j --) {
                    result[index ++] = mat[j][i - j];
                }
            } else {
                for(int j = Math.max(0, 1 - col + i); j <= Math.min(row - 1, i); j ++) {
                    result[index ++] = mat[j][i - j];
                }
            }
        }
        return result;
    }
}