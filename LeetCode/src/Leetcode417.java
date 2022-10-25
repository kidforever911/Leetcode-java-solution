class Solution {
    private int[][] st;
    int row, col;
    private int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if(heights.length == 0 || heights[0].length == 0) return result;
        row = heights.length;
        col = heights[0].length;
        st = new int[row][col];
        for(int i = 0; i < row; i ++) dfs(i, 0, 1, heights);
        for(int i = 0; i < col; i ++) dfs(0, i, 1, heights);
        for(int i = 0; i < row; i ++) dfs(i, col - 1, 2, heights);
        for(int i = 0; i < col; i ++) dfs(row - 1, i, 2, heights);

        for(int i = 0; i < row; i ++) {
            for(int j = 0; j < col; j ++) {
                if(st[i][j] == 3) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int x, int y, int t, int[][] heights) {
        if((st[x][y] & t) > 0) {
            return;
        }
        st[x][y] |= t;
        for(int i = 0; i < 4; i ++) {
            int a = x + direction[i][0];
            int b = y + direction[i][1];
            if(a >= 0 && a < row && b >= 0 && b < col && heights[a][b] >= heights[x][y]) {
                dfs(a, b, t, heights);
            }
        }
        return;
    }
}