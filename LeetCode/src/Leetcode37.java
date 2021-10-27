public class Leetcode37 {
    class Solution {
        public void solveSudoku(char[][] board) {
            boolean[][] row = new boolean[9][10];
            boolean[][] col = new boolean[9][10];
            boolean[][] block = new boolean[9][10];

            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j ++){
                    if(board[i][j] != '.'){
                        row[i][board[i][j] - '0'] = true;
                        col[j][board[i][j] - '0'] = true;
                        block[i / 3 * 3 + j / 3][board[i][j] - '0'] = true;
                    }
                }
            }

            for(int i = 0; i < 81; i++){
                if(board[i / 9][i % 9] == '.'){
                    assert(generateSudoku(board, i, row, col, block));
                    return;
                }
            }
        }

        private boolean generateSudoku(char[][] board, int currentPoint, boolean[][] row, boolean[][] col, boolean[][] block){
            if(currentPoint == 81){
                return true;
            }

            int nextPoint = currentPoint + 1;
            for(; nextPoint < 81; nextPoint ++){
                if(board[nextPoint / 9][nextPoint % 9] == '.'){
                    break;
                }
            }

            int x = currentPoint / 9;
            int y = currentPoint % 9;
            for(int i = 1; i <= 9; i++){
                if(!row[x][i] && !col[y][i] && !block[x / 3 * 3 + y / 3][i]){
                    row[x][i] = true;
                    col[y][i] = true;
                    block[x / 3 * 3 + y / 3][i] = true;
                    board[x][y] = (char)('0' + i);

                    if(generateSudoku(board, nextPoint, row, col, block)){
                        return true;
                    }
                    row[x][i] = false;
                    col[y][i] = false;
                    block[x / 3 * 3 + y / 3][i] = false;
                    board[x][y] = '.';
                }
            }
            return false;
        }
    }
}
