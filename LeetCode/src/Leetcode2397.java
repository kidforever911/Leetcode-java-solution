class Solution {
    public int maximumRows(int[][] mat, int cols) {
        int row = mat.length;
        int col = mat[0].length;
        int result = 0;
        for(int i = 0; i < 1 << col; i ++) {
            int count = 0;
            for(int j = 0; j < col; j ++) {
                count += i >> j & 1;
            }
            if(count != cols) continue;
            int total = 0;
            for(int j = 0; j < row; j ++) {
                boolean flag = true;
                for(int k = 0; k < col; k ++) {
                    if(mat[j][k] == 1 && (i >> k & 1) != 1) {
                        flag = false;
                        break;
                    }
                }
                if(flag) total ++;
            }
            result = Math.max(total, result);
        }
        return result;
    }
}