public class Leetcode200 {
    class Solution {
        private int m,n;
        private boolean[][] visited;
        private int direct[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        public int numIslands(char[][] grid) {
            if(grid == null) return 0;
            int result = 0;
            m = grid.length;
            n = grid[0].length;
            visited = new boolean[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == '1' && !visited[i][j]){
                        searchGrid(grid, i, j);
                        result++;
                    }
                }
            }
            return result;
        }

        private void searchGrid(char[][] grid, int startx, int starty){
            visited[startx][starty] = true;
            for(int i = 0; i < 4; i++){
                int newx = startx + direct[i][0];
                int newy = starty + direct[i][1];
                if(inArea(newx, newy) && !visited[newx][newy] && grid[newx][newy] == '1'){
                    searchGrid(grid, newx, newy);
                }
            }
            return;
        }

        private boolean inArea(int x, int y){
            return x >= 0 && x < m && y >= 0 && y < n;
        }
    }
}
