import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int N = 510;
        int n = in.nextInt();
        int INF = (int)(1e9);
        int[][] a = new int[N][N];
        int[][] f = new int[N][N];
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= i; j ++) {
                a[i][j] = in.nextInt();
            }
        }
        for(int i = 0; i <= n; i ++) {
            for(int j = 0; j <= i + 1; j ++) {
                f[i][j] = -INF;
            }
        }
        f[1][1] = a[1][1];
        for(int i = 2; i <= n; i ++) {
            for(int j = 1; j <= i; j ++) {
                f[i][j] = Math.max(f[i - 1][j - 1] + a[i][j], f[i - 1][j] + a[i][j]);
            }
        }
        int result = -INF;
        for(int i = 1; i <= n; i ++) result = Math.max(result, f[n][i]);
        System.out.println(result);
        return;
    }
}