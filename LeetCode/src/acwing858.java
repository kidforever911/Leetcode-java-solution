import java.io.*;
import java.util.*;

public class Main{
    private static int N = 510, INF = 0x3f3f3f;
    private static int n, m;
    private static int[][] g = new int[N][N];
    //这里的dist表示集合外的点到集合的最短距离
    private static int[] dist = new int[N];
    private static boolean[] used = new boolean[N];
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        for(int[] row : g){
            Arrays.fill(row, INF);
        }
        n = in.nextInt();
        m = in.nextInt();
        while(m -- > 0){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            g[a][b] = g[b][a] = Math.min(g[a][b], c);
        }
        int result = prim();
        if(result == INF) System.out.println("impossible");
        else System.out.println(result);
        return;
    }

    private static int prim(){
        Arrays.fill(dist, INF);
        int result = 0;
        for(int i = 0; i < n; i ++){
            int t = -1;
            for(int j = 1;  j <= n; j ++){
                if(!used[j] && (t == -1 || dist[j] < dist[t])){
                    t = j;
                }
            }
            if(i > 0 && dist[t] == INF) return INF;
            if(i > 0) result += dist[t];
            for(int j = 1; j <= n; j ++) dist[j] = Math.min(dist[j], g[t][j]);
            used[t] = true;
        }
        return result;
    }
}