import java.util.*;
import java.io.*;

public class Main{
    private static int N = 510, max = 500 * 10000 + 10;
    private static int[][] g = new int[N][N];
    private static int[] dist = new int[N];
    private static int n, m;
    private static boolean[] visited = new boolean[N];
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= n; j ++){
                if(i == j) g[i][j] = 0;
                g[i][j] = max;
            }
        }
        while(m -- > 0){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            g[a][b] = Math.min(g[a][b], c);

        }
        int result = dijkstra();
        System.out.println(result);
        return;
    }
    private static int dijkstra(){
        Arrays.fill(dist, max);
        dist[1] = 0;
        for(int i = 0; i < n; i ++){
            int t = -1;
            for(int j = 1; j <= n; j ++){
                if(!visited[j] && (t == -1 || dist[t] > dist[j])){
                    t = j;
                }
            }
            visited[t] = true;
            for(int j = 1; j <= n; j ++){
                dist[j] = Math.min(dist[t] + g[t][j], dist[j]);
            }
        }
        if(dist[n] == max) return -1;
        return dist[n];
    }
}