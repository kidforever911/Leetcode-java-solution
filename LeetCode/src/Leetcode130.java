class Solution {
    private int row;
    private int col;
    private int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void solve(char[][] board) {
        row = board.length;
        if(row == 0) return;
        col = board[0].length;

        for(int i = 0; i < row; i ++){
            if(board[i][0] == 'O') dfs(i, 0, board);
            if(board[i][col - 1] == 'O') dfs(i, col - 1, board);
        }

        for(int j = 0; j < col; j ++){
            if(board[0][j] == 'O') dfs(0, j, board);
            if(board[row - 1][j] == 'O') dfs(row - 1, j, board);
        }

        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(board[i][j] == '#') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }

    private void dfs(int x, int y, char[][] board){
        board[x][y] = '#';
        for(int i = 0; i < 4; i ++){
            int newx = x + direction[i][0];
            int newy = y + direction[i][1];
            if(newx >= 0 && newx < row && newy >= 0 && newy < col && board[newx][newy] == 'O'){
                dfs(newx, newy, board);
            }
        }
        return;
    }
}