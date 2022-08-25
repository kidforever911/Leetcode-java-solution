class Solution {
    public int countServers(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int totalServer = 0;
        int[] rowServer = new int[row];
        int[] colServer = new int[col];
        for(int i = 0; i < row; i ++) {
            for(int j = 0; j < col; j ++) {
                if(grid[i][j] == 1) {
                    totalServer ++;
                    rowServer[i] ++;
                    colServer[j] ++;
                }
            }
        }
        for(int i = 0; i < row; i ++) {
            for(int j = 0; j < col; j ++) {
                if(grid[i][j] == 1) {
                    if(rowServer[i] == 1 && colServer[j] == 1) {
                        totalServer --;
                    }
                }
            }
        }
        return totalServer;
    }
}