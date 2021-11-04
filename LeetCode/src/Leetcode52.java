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

    private int calculateNQueens(int n, int row){
        if(row == n){
            return 1;
        }
        int result = 0;
        for(int i = 0; i < n; i ++){
            if(!col[i] && !dia1[row + i] && !dia2[row - i + n - 1]){
                col[i] = dia1[row + i] = dia2[row - i + n - 1] = true;
                result += calculateNQueens(n, row + 1);
                col[i] = dia1[row + i] = dia2[row - i + n - 1] = false;
            }
        }
        return result;
    }
}