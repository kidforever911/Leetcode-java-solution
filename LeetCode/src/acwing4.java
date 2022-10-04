import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int N = 110;
        int[] w = new int[N];
        int[] v = new int[N];
        int[] s = new int[N];
        int n = in.nextInt();
        int m = in.nextInt();
        for(int i = 1; i <= n; i ++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
            s[i] = in.nextInt();
        }
        int[][] f = new int[N][N];
        for(int i = 1; i <= n; i ++) {
            for(int j = 0; j <= m; j ++) {
                for(int k = 0; k <= s[i] && k * v[i] <= j; k ++) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i]);
                }
            }
        }
        System.out.println(f[n][m]);
    }
}