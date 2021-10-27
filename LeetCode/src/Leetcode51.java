import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode51 {
    class Solution {
        private boolean[] col;
        private boolean[] dia1;
        private boolean[] dia2;

        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();
            if(n == 0) return result;
            col = new boolean[n];
            dia1 = new boolean[2 * n - 1];
            dia2 = new boolean[2 * n - 1];
            LinkedList<Integer> record = new LinkedList<>();
            generateQueens(n, 0, record, result);
            return result;

        }

        private void generateQueens(int n, int index, LinkedList<Integer> record, List<List<String>> result){
            if(index == n){
                result.add(generateBoard(n, record));
                return;
            }

            for(int i = 0; i < n; i++){
                if(!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]){
                    record.addLast(i);
                    col[i] = true;
                    dia1[index + i] = true;
                    dia2[index - i + n - 1] = true;
                    generateQueens(n, index + 1, record, result);
                    record.removeLast();
                    col[i] = false;
                    dia1[index + i] = false;
                    dia2[index - i + n - 1] = false;
                }
            }
            return;
        }

        private List<String> generateBoard(int n, LinkedList<Integer> record){
            ArrayList<String> board = new ArrayList<>();
            for(int i = 0; i < n; i++){
                char[] charArray = new char[n];
                Arrays.fill(charArray, '.');
                charArray[record.get(i)] = 'Q';
                board.add(new String(charArray));
            }
            return board;
        }
    }
}
