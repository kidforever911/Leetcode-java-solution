import java.io.*;
import java.util.*;

public class Main{
    private static int N = 510, M = 10010;
    private static int n, m, k;
    private static int INF = 0x3f3f3f3f;
    private static int[] dist = new int[N];
    private static int[] backup = new int[N];
    private static Edge[] e = new Edge[M];
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        for(int i = 0; i < m; i ++){
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
            e[i] = new Edge(a, b, w);
        }
        bellmanFord();
        return;
    }

    private static void bellmanFord(){
        Arrays.fill(dist, INF);
        dist[1] = 0;
        for(int i = 0; i < k; i ++){
            backup = Arrays.copyOf(dist, n + 1);
            for(int j = 0; j < m; j ++){
                Edge temp = e[j];
                int start = temp.a;
                int end = temp.b;
                int weight = temp.w;
                dist[end] = Math.min(dist[end], backup[start] + weight);
            }
        }
        if(dist[n] > INF / 2) System.out.println("impossible");
        else System.out.println(dist[n]);
        return;
    }
}

class Edge{
    int a;
    int b;
    int w;
    public Edge(){}
    public Edge(int a, int b, int w){
        this.a = a;
        this.b = b;
        this.w = w;
    }
}

