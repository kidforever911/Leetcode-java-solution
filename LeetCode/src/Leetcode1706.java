class Solution {
    public int[] findBall(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] result = new int[col];
        for(int i = 0; i < col; i ++) {
            int x = 0, y = i, z = 0;
            while(x < row) {
                if(z == 0) {
                    if(grid[x][y] == 1) {
                        if(y + 1 >= col || grid[x][y + 1] == -1) y = -1;
                        else {
                            y ++;
                            z = 1;
                        }
                    } else {
                        if(y - 1 < 0 || grid[x][y - 1] == 1) y = -1;
                        else {
                            y --;
                            z = 1;
                        }
                    }
                } else {
                    x ++;
                    z = 0;
                }
                if(y == -1) break;
            }
            result[i] = y;
        }
        return result;
    }
}