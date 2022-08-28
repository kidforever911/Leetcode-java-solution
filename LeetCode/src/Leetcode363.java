class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int result = Integer.MIN_VALUE;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] preSum = new int[row + 1][col + 1];
        for(int i = 1; i <= row; i ++) {
            for(int j = 1; j <= col; j ++) {
                preSum[i][j] = matrix[i - 1][j - 1] + preSum[i][j - 1] + preSum[i - 1][j] - preSum[i - 1][j - 1];
            }
        }
        for(int x1 = 1; x1 <= row; x1 ++) {
            for(int x2 = x1; x2 <= row; x2 ++) {
                TreeSet<Integer> record = new TreeSet<>();
                record.add(0);
                for(int j = 1; j <= col; j ++) {
                    int sj = get(x1, 1, x2, j, preSum);
                    Integer si = record.ceiling(sj - k);
                    if(si != null) result = Math.max(result, sj - si);
                    record.add(sj);
                }
            }
        }
        return result;
    }
    private int get(int x1, int y1, int x2, int y2, int[][] preSum) {
        return preSum[x2][y2] - preSum[x2][y1 - 1] - preSum[x1 - 1][y2] + preSum[x1 - 1][y1 - 1];
    }
}