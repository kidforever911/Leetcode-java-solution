class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        boolean[][] used = new boolean[n][n];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int direction = 0;
        int x = 0, y = 0;
        for(int i = 1; i <= n * n; i ++){
            result[x][y] = i;
            used[x][y] = true;
            int a = x + dx[direction];
            int b = y + dy[direction];
            if(a < 0 || a >= n || b < 0 || b >= n || used[a][b]){
                direction = (direction + 1) % 4;
                a = x + dx[direction];
                b = y + dy[direction];
            }
            x = a;
            y = b;
        }
        return result;
    }
}

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] isVisited = new boolean[n][n];
        int index = 0;
        int x = 0, y = 0;
        for(int i = 1; i <= n * n; i ++) {
            result[x][y] = i;
            isVisited[x][y] = true;
            int newx = direction[index][0] + x;
            int newy = direction[index][1] + y;
            if(newx < 0 || newx >= n || newy < 0 || newy >= n || isVisited[newx][newy]) {
                index = (index + 1) % 4;
                newx = direction[index][0] + x;
                newy = direction[index][1] + y;
            }
            x = newx;
            y = newy;
        }
        return result;
    }
}