import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        int[] v = new int[n];
        int[] w = new int[n];
        for(int i = 0; i < n; i ++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        int[][] f = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i ++) {
            for(int j = 0; j <= m; j ++) {
                for(int k = 0; k * v[i - 1] <= j; k ++) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i - 1] * k] + k * w[i - 1]);
                }
            }
        }
        System.out.println(f[n][m]);
        return;
    }
}
//未优化版
public class Main{
    private static int N =1010;
    private static int[] v = new int[N];
    private static int[] w = new int[N];
    private static int[][] f = new int[N][N];
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        for(int i = 1; i <= n; i ++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                f[i][j] = f[i - 1][j];
                if(j >= v[i]) f[i][j] = Math.max(f[i][j], f[i][j - v[i]] + w[i]);
            }
        }
        System.out.println(f[n][m]);
    }
}
//优化版
public class Main
{
    static Scanner in = new Scanner(System.in);
    static int N = 1010;
    static int v[] = new int[N], w[] = new int[N], f[] = new int[N];

    public static void main(String args[])
    {
        int n = in.nextInt(), m = in.nextInt();
        for (int i = 1; i <= n; i++)
        {
            v[i] = in.nextInt(); w[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++)
            for (int j = v[i]; j <= m; j++)
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
        System.out.println(f[m]);
    }

}

