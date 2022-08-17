class Solution {
    public int[][] candyCrush(int[][] board) {
        boolean found = true;
        int row = board.length;
        int col = board[0].length;
        while(found) {
            found = false;
            for(int i = 0; i < row; i ++) {
                for(int j = 0; j < col; j ++) {
                    int val = Math.abs(board[i][j]);
                    if(val == 0) continue;
                    if(j < col - 2 && Math.abs(board[i][j + 1]) == val && Math.abs(board[i][j + 2]) == val) {
                        found = true;
                        int temp = j;
                        while(temp < col && Math.abs(board[i][temp]) == val) board[i][temp ++] = -val;
                    }
                    if(i < row - 2 && Math.abs(board[i + 1][j]) == val && Math.abs(board[i + 2][j]) == val) {
                        found = true;
                        int temp = i;
                        while(temp < row && Math.abs(board[temp][j]) == val) board[temp ++][j] = -val;
                    }
                }
            }
            if(found) {
                for(int j = 0; j < col; j ++) {
                    int last = row - 1;
                    for(int i = row - 1; i >= 0; i --){
                        if(board[i][j] > 0) {
                            board[last --][j] = board[i][j];
                        }
                    }
                    for(int k = last; k >= 0; k --) {
                        board[k][j] = 0;
                    }
                }
            }
        }
        return board;
    }
}