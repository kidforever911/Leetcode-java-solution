class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> record = new ArrayDeque<>();
        int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int row = rooms.length;
        int col = rooms[0].length;
        for(int i = 0; i < row; i ++) {
            for(int j = 0; j < col; j ++) {
                if(rooms[i][j] == 0) {
                    record.add(new int[]{i, j});
                }
            }
        }
        while(!record.isEmpty()) {
            int length = record.size();
            for(int i = 0; i < length; i ++) {
                int[] cur = record.poll();
                int x = cur[0];
                int y = cur[1];
                for(int j = 0; j < 4; j ++) {
                    int newx = x + direction[j][0];
                    int newy = y + direction[j][1];
                    if(newx >= 0 && newx < row && newy >= 0 && newy < col && rooms[newx][newy] == Integer.MAX_VALUE) {
                        rooms[newx][newy] = rooms[x][y] + 1;
                        record.add(new int[]{newx, newy});
                    }
                }
            }
        }
        return;
    }
}