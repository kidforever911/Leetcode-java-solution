import java.util.Arrays;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[] sudo = new boolean[n];

        for(int i = 0; i < m; i ++){
            Arrays.fill(sudo, false);
            for(int j = 0; j < n; j ++){
                if(board[i][j] != '.'){
                    int t = board[i][j] - '1';
                    if(sudo[t]) return false;
                    sudo[t] = true;
                }
            }
        }


        for(int i = 0; i < m; i ++){
            Arrays.fill(sudo, false);
            for(int j = 0; j < n; j ++){
                if(board[j][i] != '.'){
                    int t = board[j][i] - '1';
                    if(sudo[t]) return false;
                    sudo[t] = true;
                }
            }
        }


        for(int i = 0; i < m; i += 3){
            for(int j = 0; j < n; j += 3){
                Arrays.fill(sudo, false);
                for(int x = 0; x < 3; x ++){
                    for(int y = 0; y < 3; y ++){
                        if(board[i + x][j + y] != '.'){
                            int t = board[i + x][j + y] - '1';
                            if(sudo[t]) return false;
                            sudo[t] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}


class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] row = new boolean[m][10];
        boolean[][] col = new boolean[n][10];
        boolean[][][] cell = new boolean[m / 3][n / 3][10];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(board[i][j] != '.'){
                    int number = board[i][j] - '0';
                    if(row[i][number] || col[j][number] || cell[i / 3][j / 3][number]) return false;
                    row[i][number] = true;
                    col[j][number] = true;
                    cell[i / 3][j / 3][number] = true;
                }
            }
        }
        return true;
    }
}