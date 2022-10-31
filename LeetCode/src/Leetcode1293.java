class Solution {
    public int shortestPath(int[][] grid, int k) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int INF = (int)(1e9);
        int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int[][][] dist = new int[row][col][k + 1];
        for(int i = 0; i < row; i ++) {
            for(int j = 0; j < col; j ++) {
                Arrays.fill(dist[i][j], INF);
            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0});
        dist[0][0][0] = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int distance = dist[cur[0]][cur[1]][cur[2]];
            if(cur[0] == row - 1 && cur[1] == col - 1) return distance;
            for(int i = 0; i < 4; i ++) {
                int newx = cur[0] + direction[i][0];
                int newy = cur[1] + direction[i][1];
                if(newx >= 0 && newx < row && newy >= 0 && newy < col) {
                    int z = cur[2] + grid[newx][newy];
                    if(z <= k && dist[newx][newy][z] > distance + 1) {
                        dist[newx][newy][z] = distance + 1;
                        q.add(new int[]{newx, newy, z});
                    }
                }
            }
        }

        return -1;
    }
}