import java.util.Arrays;

public class Leetcode63 {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if(obstacleGrid.length == 0) return 0;
            int row = obstacleGrid.length;
            int col = obstacleGrid[0].length;
            int[][] record = new int[row][col];
            for(int[] m : record) Arrays.fill(m, -1);
            return calculateUniquePathWithObstacles(obstacleGrid, record, row - 1, col - 1);
        }

        private int calculateUniquePathWithObstacles(int[][] obstacleGrid, int[][] record, int row, int col){
            if(row < 0 || col < 0 || obstacleGrid[row][col] == 1) return 0;
            if(row == 0 && col == 0) return 1;
            if(record[row][col] != -1) return record[row][col];
            record[row][col] = calculateUniquePathWithObstacles(obstacleGrid, record, row - 1, col) + calculateUniquePathWithObstacles(obstacleGrid, record, row, col - 1);
            return record[row][col];

        }
    }

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int row = obstacleGrid.length;
            int col = obstacleGrid[0].length;
            if(row == 0 || col == 0) return 0;

            int[][] record = new int[row][col];

            for(int i = 0; i < row; i ++){
                if(obstacleGrid[i][0] == 1){
                    record[i][0] = 0;
                    break;
                }else{
                    record[i][0] = 1;
                }
            }

            for(int j = 0; j < col; j ++){
                if(obstacleGrid[0][j] == 1){
                    record[0][j] = 0;
                    break;
                }else{
                    record[0][j] = 1;
                }
            }

            for(int i = 1; i < row; i ++){
                for(int j = 1; j < col; j ++){
                    if(obstacleGrid[i][j] == 1){
                        record[i][j] = 0;
                    }else{
                        record[i][j] = record[i - 1][j] + record[i][j - 1];
                    }
                }
            }
            return record[row - 1][col - 1];
        }
    }
}
