import java.util.*;
import java.io.*;

public class Main{
    private static int N = 20, M = 1 << N;
    private static int[][] f = new int[M][N];
    private static int[][] w = new int[N][N];
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                w[i][j] = in.nextInt();
            }
        }
        int INF = (int)(1e6 + 7);
        for(int i = 0; i < f.length; i ++) {
            Arrays.fill(f[i], INF);
        }
        f[1][0] = 0;
        for(int i = 0; i < 1 << n; i ++) {
            for(int j = 0; j < n; j ++) {
                if((i >> j & 1) == 1) {
                    for(int k = 0; k < n; k ++) {
                        if(((i - (1 << j)) >> k & 1) == 1) {
                            f[i][j] = Math.min(f[i][j], f[i - (1 << j)][k] + w[k][j]);
                        }
                    }
                }
            }
        }
        System.out.println(f[(1 << n) - 1][n - 1]);
    }
}