class Solution {
    private int direction[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int row;
    private int col;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if(board == null || word == null)
            throw new IllegalArgumentException("board or word cannot be null");
        row = board.length;
        if(row == 0)
            throw new IllegalArgumentException("board cannot be empty");
        col = board[0].length;
        if(col == 0)
            throw new IllegalArgumentException("board cannot be empty");
        visited = new boolean[row][col];
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(searchWord(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int startx, int starty){
        if(index == word.length() - 1){
            return board[startx][starty] == word.charAt(index);
        }
        if(board[startx][starty] == word.charAt(index)){
            visited[startx][starty] = true;
            for(int i = 0; i < 4; i ++){
                int newx = startx + direction[i][0];
                int newy = starty + direction[i][1];
                if(inArea(newx, newy) && !visited[newx][newy]){
                    if(searchWord(board, word, index + 1, newx, newy))
                        return true;
                }
            }
            visited[startx][starty] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
