import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int N = 110;
        int[] s = new int[N];
        int[][] v = new int[N][N];
        int[][] w = new int[N][N];
        int n = in.nextInt();
        int m = in.nextInt();
        int[] f = new int[m + 1];
        for(int i = 1; i <= n; i ++) {
            s[i] = in.nextInt();
            for(int j = 1; j <= s[i]; j ++) {
                v[i][j] = in.nextInt();
                w[i][j] = in.nextInt();
            }
        }
        for(int i = 1; i <= n; i ++) {
            for(int j = m; j >= 0; j --) {
                for(int k = 0; k <= s[i]; k ++) {
                    if(j >= v[i][k]) f[j] = Math.max(f[j], f[j - v[i][k]] + w[i][k]);
                }
            }
        }
        System.out.println(f[m]);
        return;
    }
}