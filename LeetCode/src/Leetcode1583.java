class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int result = 0;
        int[][] rank = new int[n][n];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n - 1; j ++) {
                //在i心里j的重要性，数值越小越重要
                rank[i][preferences[i][j]] = j;
            }
        }
        for(int i = 0; i < pairs.length; i ++) {
            boolean unhappyX = false;
            boolean unhappyY = false;
            int x = pairs[i][0];
            int y = pairs[i][1];
            for(int j = 0; j < pairs.length; j ++) {
                if(i == j) continue;
                int u = pairs[j][0];
                int v = pairs[j][1];
                if(!unhappyX && (check(rank, x, y, u, v) || check(rank, x, y, v, u))){
                    unhappyX = true;
                    result ++;
                }
                if(!unhappyY && (check(rank, y, x, u, v) || check(rank, y, x, v, u))){
                    unhappyY = true;
                    result ++;
                }
                if(unhappyX && unhappyY) break;
            }
        }
        return result;
    }
    private boolean check(int[][] rank, int x, int y, int u, int v) {
        return rank[x][u] < rank[x][y] && rank[u][x] < rank[u][v];
    }
}