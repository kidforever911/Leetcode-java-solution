//dfs暴力检索法
class Solution {
    private int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] visited;
    private int row, col, n;
    public List<String> findWords(char[][] board, String[] words) {
        row = board.length;
        col = board[0].length;
        n = words.length;
        List<String> result = new ArrayList<>();
        if(row == 0 || col == 0|| n == 0) return result;
        for(int i = 0; i < n; i ++){
            String searchWord = words[i];
            visited = new boolean[row][col];
            for(int j = 0; j < row; j ++){
                for(int k = 0; k < col; k ++){
                    if(dfs(board, searchWord, 0, j, k)){
                        if(!result.contains(searchWord))
                            result.add(searchWord);
                    }
                }
            }
        }
        return result;
    }

    private boolean dfs(char[][] board, String searchWord, int index, int x, int y){
        if(index == searchWord.length() - 1) return board[x][y] == searchWord.charAt(index);
        if(board[x][y] == searchWord.charAt(index)){
            visited[x][y] = true;
            for(int i = 0; i < 4; i ++){
                int newx = x + direction[i][0];
                int newy = y + direction[i][1];
                if(inArea(newx, newy) && !visited[newx][newy]){
                    if(dfs(board, searchWord, index + 1, newx, newy)){
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}

//TrieNode法
class Solution {
    private int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private TrieNode root;
    private boolean[][] visited;
    private int row, col, n;

    public class TrieNode{
        int id;
        TrieNode[] next;
        public TrieNode(){
            id = -1;
            next = new TrieNode[26];
        }
    }

    private void insert(String word, int id){
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            int u = c - 'a';
            if(cur.next[u] == null) cur.next[u] = new TrieNode();
            cur = cur.next[u];
        }
        cur.id = id;
    }


    public List<String> findWords(char[][] board, String[] words) {
        row = board.length;
        col = board[0].length;
        n = words.length;
        List<String> result = new ArrayList<>();
        root = new TrieNode();
        visited = new boolean[row][col];
        HashSet<Integer> record = new HashSet<>();
        if(row == 0 || col == 0|| n == 0) return result;
        for(int i = 0; i < n; i ++){
            insert(words[i], i);
        }

        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                int u = board[i][j] - 'a';
                if(root.next[u] != null){
                    dfs(board, i, j, record, root.next[u]);
                }
            }
        }
        for(int i : record){
            result.add(words[i]);
        }
        return result;
    }

    private void dfs(char[][] board, int x, int y, HashSet<Integer> record, TrieNode root){
        if(root.id != -1) record.add(root.id);
        visited[x][y] = true;
        for(int i = 0; i < 4; i ++){
            int newx = x + direction[i][0];
            int newy = y + direction[i][1];
            if(inArea(newx, newy) && !visited[newx][newy]){
                int u = board[newx][newy] - 'a';
                if(root.next[u] != null) dfs(board, newx, newy, record, root.next[u]);
            }
        }
        visited[x][y] = false;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}