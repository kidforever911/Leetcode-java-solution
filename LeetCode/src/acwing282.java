import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int N = 310;
        int n = in.nextInt();
        int[] s = new int[N];
        for(int i = 1; i <= n; i ++) s[i] = in.nextInt();
        for(int i = 1; i <= n; i ++) s[i] += s[i - 1];
        int[][] f = new int[N][N];
        for(int len = 2; len <= n; len ++) {
            for(int i = 1; i + len - 1 <= n; i ++) {
                int l = i, r = i + len - 1;
                f[l][r] = (int)(1e8);
                for(int k = l; k < r; k ++) {
                    f[l][r] = Math.min(f[l][r], f[l][k] + f[k + 1][r] + s[r] - s[l - 1]);
                }
            }
        }
        System.out.println(f[1][n]);
        return;
    }
}