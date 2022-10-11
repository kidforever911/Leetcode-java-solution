import java.util.*;
import java.io.*;

public class Main{
    private static int N = 310;
    private static int row, col;
    private static int[][] h = new int[N][N];
    private static int[][] f = new int[N][N];
    private static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        row = in.nextInt();
        col = in.nextInt();
        for(int i = 1; i <= row; i ++) {
            for(int j = 1; j <= col; j ++) {
                h[i][j] = in.nextInt();
            }
        }
        for(int i = 0; i < f.length; i ++) {
            Arrays.fill(f[i], -1);
        }
        int result = 0;
        for(int i = 1; i <= row; i ++) {
            for(int j = 1; j <= col; j ++) {
                result = Math.max(result, dp(i, j));
            }
        }
        System.out.println(result);
    }

    private static int dp(int x, int y) {
        if(f[x][y] != -1) return f[x][y];
        f[x][y] = 1;
        for(int i = 0; i < 4; i ++) {
            int newx = x + direction[i][0];
            int newy = y + direction[i][1];
            if(newx >= 1 && newx <= row && newy >= 1 && newy <= col && h[newx][newy] < h[x][y]) {
                f[x][y] = Math.max(f[x][y], dp(newx, newy) + 1);
            }
        }
        return f[x][y];
    }
}