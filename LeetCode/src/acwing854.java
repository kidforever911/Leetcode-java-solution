import java.io.*;
import java.util.*;

public class Main{
    private static int N = 210, INF = 0x3f3f3f3f;
    private static int[][] d = new int[N][N];
    private static int n, m, Q;
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        Q = in.nextInt();
        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= n; j ++){
                if(i == j) d[i][j] = 0;
                else d[i][j] = INF;
            }
        }
        while(m -- > 0){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            d[a][b] = Math.min(d[a][b], c);
        }
        floyd();
        while(Q -- > 0){
            int a = in.nextInt();
            int b = in.nextInt();
            if(d[a][b] > INF / 2) System.out.println("impossible");
            else System.out.println(d[a][b]);
        }
        return;
    }

    private static void floyd(){
        for(int k = 1; k <= n; k ++){
            for(int i = 1; i <= n; i ++){
                for(int j = 1; j <= n; j ++){
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
        return;
    }
}