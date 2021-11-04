import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n == 0) return result;
        LinkedList<Integer> record = new LinkedList<>();
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        generateQueens(n, 0, record, result);
        return result;
    }

    private void generateQueens(int n, int row, LinkedList<Integer> record, List<List<String>> result){
        if(row == n){
            result.add(generateBoard(n, record));
            return;
        }
        for(int i = 0; i < n; i ++){
            if(!col[i] && !dia1[row + i] && !dia2[row - i + n - 1]){
                col[i] = dia1[row + i] = dia2[row - i + n - 1] = true;
                record.addLast(i);
                generateQueens(n, row + 1, record, result);
                col[i] = dia1[row + i] = dia2[row - i + n - 1] = false;
                record.removeLast();
            }
        }
        return;
    }

    private List<String> generateBoard(int n, LinkedList<Integer> record){
        List<String> board = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            char[] letters = new char[n];
            Arrays.fill(letters, '.');
            letters[record.get(i)] = 'Q';
            board.add(new String(letters));
        }
        return board;
    }
}