import java.util.Arrays;


class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] record = new int[m + 1][n + 1];
        for (int[] row : record) {
            Arrays.fill(row, -1);
        }
        return calculateUniquePaths(m - 1, n - 1, record);
    }

    private int calculateUniquePaths(int m, int n, int[][] record) {
        if (m < 0 || n < 0) return 0;
        if (m == 0 && n == 0) return 1;
        if (record[m][n] != -1) return record[m][n];
        record[m][n] = calculateUniquePaths(m - 1, n, record) + calculateUniquePaths(m, n - 1, record);
        return record[m][n];
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] record = new int[m][n];
        for (int i = 0; i < m; i++) {
            record[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            record[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                record[i][j] = record[i - 1][j] + record[i][j - 1];
            }
        }
        return record[m - 1][n - 1];
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 0;
        int[][] f = new int[m][n];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(i == 0 && j == 0){
                    f[i][j] = 1;
                }else{
                    if(i > 0) f[i][j] += f[i - 1][j];
                    if(j > 0) f[i][j] += f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }
}

