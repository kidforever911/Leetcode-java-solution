import java.io.*;
import java.util.*;

public class Main{
    private static int N = 100010, M = 2 * N;
    private static int[] p = new int[N];
    private static Edge[] e = new Edge[M];
    private static int n, m;
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        for(int i = 0; i < m; i ++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            e[i] = new Edge(a, b, c);
        }
        kruskal();
    }
    private static void kruskal(){
        int result = 0;
        int count = 0;
        Arrays.sort(e, 0, m, (a, b) -> (a.weight - b.weight));
        for(int i = 1; i <= n; i ++) p[i] = i;
        for(int i = 0; i < m; i ++){
            int a = e[i].start, b = e[i].end, w = e[i].weight;
            a = find(a);
            b = find(b);
            if(a != b){
                p[a] = b;
                result += w;
                count ++;
            }
        }
        if(count < n - 1) System.out.println("impossible");
        else System.out.println(result);
        return;

    }

    private static int find(int x){
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}

class Edge{
    int start;
    int end;
    int weight;
    public Edge(){}
    public Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}