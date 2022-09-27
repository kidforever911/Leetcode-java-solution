import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        int[] v = new int[n];
        int[] w = new int[n];
        int[][] f = new int[n + 1][m + 1];
        for(int i = 0; i < n; i ++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        for(int i = 1; i <= n; i ++) {
            for(int j = 0; j <= m; j ++) {
                f[i][j] = f[i - 1][j];
                if(j >= v[i - 1]) f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i - 1]] + w[i - 1]);
            }
        }
        System.out.println(f[n][m]);
        return;
    }
}


public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        int[] v = new int[n];
        int[] w = new int[n];
        int[] f = new int[m + 1];
        for(int i = 0; i < n; i ++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        for(int i = 1; i <= n; i ++) {
            for(int j = m; j >= v[i - 1]; j --) {
                f[j] = Math.max(f[j], f[j - v[i - 1]] + w[i - 1]);
            }
        }
        System.out.println(f[m]);
        return;
    }
}