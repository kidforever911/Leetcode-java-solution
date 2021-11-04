import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        if(n == 0) return result;

        boolean[][] used = new boolean[n][m];
        //x表示行，y表示列
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int x = 0, y = 0, direction = 0;
        for(int i = 0; i < n * m; i ++){
            result.add(matrix[x][y]);
            used[x][y] = true;

            int a = x + dx[direction], b = y + dy[direction];
            if(a < 0 || a >= n || b < 0 || b >= m || used[a][b]){
                direction = (direction + 1) % 4;
                a = x + dx[direction];
                b = y + dy[direction];
            }

            x = a;
            y = b;
        }
        return result;
    }
}