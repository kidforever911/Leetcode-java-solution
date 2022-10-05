import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        String A = " " + in.next();
        String B = " " + in.next();
        int[][] f = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if(A.charAt(i) == B.charAt(j)) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        System.out.println(f[n][m]);
        return;
    }
}