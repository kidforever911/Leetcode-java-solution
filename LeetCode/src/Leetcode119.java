import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if(rowIndex < 0) return result;
        int[][] f = new int [2][rowIndex + 1];
        for(int i = 0; i <= rowIndex; i ++){
            f[i & 1][0] = f[i & 1][i] = 1;
            for(int j = 1; j < i; j ++){
                f[i & 1][j] = f[i - 1 & 1][j - 1] + f[i - 1 & 1][j];
            }
        }
        for(int i = 0; i < rowIndex + 1; i ++){
            result.add(f[rowIndex & 1][i]);
        }
        return result;
    }
}