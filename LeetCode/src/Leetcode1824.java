class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length - 1;
        int[][] f = new int[n + 1][3];
        f[0][1] = 0;
        f[0][0] = f[0][2] = 1;
        int INF = (int)1e6;
        for(int i = 1; i <= n; i ++) {
            for(int j = 0; j < 3; j ++) {
                f[i][j] = INF;
                if(obstacles[i] == j + 1) continue;
                for(int k = 0; k < 3; k ++) {
                    if(obstacles[i] == k + 1) continue;
                    int cost = 0;
                    if(k != j) cost = 1;
                    f[i][j] = Math.min(f[i][j], f[i - 1][k] + cost);
                }
            }
        }
        return Math.min(f[n][0], Math.min(f[n][1], f[n][2]));
    }
}