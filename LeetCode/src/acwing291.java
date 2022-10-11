import java.util.*;
import java.io.*;

public class Main{
    private static int N = 12, M = 1 << N;
    private static int row, col;
    private static long[][] f;
    private static boolean[] st = new boolean[M];
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while(in.hasNext()) {
            row = in.nextInt();
            col = in.nextInt();
            if(row == 0 || col == 0) continue;
            for(int i = 0; i < 1 << row; i ++) {
                f = new long[N][M];
                st[i] = true;
                int count = 0;
                for(int j = 0; j < row; j ++) {
                    if((i >> j & 1) == 1) {
                        if((count & 1) == 1) st[i] = false;
                        count = 0;
                    }else {
                        count ++;
                    }
                }
                if((count & 1) == 1) st[i] = false;
            }

            f[0][0] = 1;
            for(int i = 1; i <= col; i ++) {
                for(int j = 0; j < 1 << row; j ++) {
                    for(int k = 0; k < 1 << row; k ++) {
                        if((j & k) == 0 && st[j | k]) {
                            f[i][j] += f[i - 1][k];
                        }
                    }
                }
            }
            System.out.println(f[col][0]);
        }
    }
}