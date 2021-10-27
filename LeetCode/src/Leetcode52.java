public class Leetcode52 {
    class Solution {
        private boolean[] col;
        private boolean[] dia1;
        private boolean[] dia2;

        public int totalNQueens(int n) {
            if(n == 0) return 0;
            col = new boolean[n];
            dia1 = new boolean[2 * n - 1];
            dia2 = new boolean[2 * n - 1];
            return calculateNQueens(n, 0);
        }

        private int calculateNQueens(int n, int index){
            if(index == n){
                return 1;
            }
            int result = 0;
            for(int i = 0; i < n; i++){
                if(!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]){
                    col[i] = true;
                    dia1[index + i] = true;
                    dia2[index - i + n - 1] = true;
                    result += calculateNQueens(n, index + 1);
                    col[i] = false;
                    dia1[index + i] = false;
                    dia2[index - i + n - 1] = false;
                }
            }
            return result;
        }
    }
}
