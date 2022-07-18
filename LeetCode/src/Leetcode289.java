class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i ++) {
            for(int j = 0; j < col; j ++) {
                int live = 0;
                for(int x = Math.max(0, i - 1); x <= Math.min(row - 1, i + 1); x ++) {
                    for(int y = Math.max(0, j - 1); y <= Math.min(col - 1, j + 1); y ++) {
                        if((x != i || y != j) && ((board[x][y] & 1) == 1)) {
                            live ++;
                        }
                    }
                }
                int cur = board[i][j] & 1;
                int next = 0;
                if(cur == 1) {
                    if(live < 2 || live > 3) next = 0;
                    else next = 1;
                } else {
                    if(live == 3) next = 1;
                    else next = 0;
                }
                board[i][j] |= next << 1;
            }
        }
        for(int i = 0; i < row; i ++) {
            for(int j = 0; j < col; j ++) {
                board[i][j] >>= 1;
            }
        }
    }
}