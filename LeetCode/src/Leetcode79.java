
class Solution {
    private int direct[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m, n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null)
            throw new IllegalArgumentException("board or word cannot be null");
        m = board.length;
        if (m == 0)
            throw new IllegalArgumentException("board cannot be empty");
        n = board[0].length;
        if (n == 0)
            throw new IllegalArgumentException("board cannot be empty");
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWord(board, word, 0, i, j))
                    return true;
            }
        }
        return false;

    }

    private boolean searchWord(char[][] board, String word, int index, int startx, int starty) {
        if (index == word.length() - 1) {
            return board[startx][starty] == word.charAt(index);
        }
        if (board[startx][starty] == word.charAt(index)) {
            visited[startx][starty] = true;
            for (int i = 0; i < 4; i++) {
                int newx = startx + direct[i][0];
                int newy = starty + direct[i][1];
                if (inArea(newx, newy) && !visited[newx][newy]) {
                    if (searchWord(board, word, index + 1, newx, newy)) {
                        return true;
                    }
                }
            }
            visited[startx][starty] = false;
        }
        return false;
    }

    private boolean inArea(int newx, int newy) {
        return newx >= 0 && newx < m && newy >= 0 && newy < n;
    }
}

