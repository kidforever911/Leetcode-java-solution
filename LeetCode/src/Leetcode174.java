import java.util.Arrays;

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        if(row == 0 || col == 0) return 0;
        int[][] f= new int[row][col];
        for(int[] rows : f){
            Arrays.fill(rows, Integer.MAX_VALUE);
        }

        for(int i = row - 1; i >= 0; i --){
            for(int j = col - 1; j >= 0; j --){
                if(i == row - 1 && j == col - 1) f[i][j] = Math.max(1, 1 - dungeon[i][j]);
                else{
                    if(i + 1 < row) f[i][j] = f[i + 1][j] - dungeon[i][j];
                    if(j + 1 < col) f[i][j] = Math.min(f[i][j], f[i][j + 1] - dungeon[i][j]);
                    f[i][j] = Math.max(1, f[i][j]);
                }
            }
        }
        return f[0][0];
    }
}