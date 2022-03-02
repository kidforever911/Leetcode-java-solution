import java.util.*;
import java.io.*;

public class Main{
    private static int N = 100010, M = 2 * N, INF = 0x3f3f3f;
    private static int[] h = new int[N];
    private static int[] e = new int[M];
    private static int[] ne = new int[M];
    private static int[] w = new int[M];
    private static int[] dist = new int[N];
    private static boolean[] used = new boolean[N];
    private static int n, m, idx;
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h, -1);
        while(m -- > 0){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            add(a, b, c);
        }
        spfa();
        return;
    }

    private static void add(int a, int b, int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx ++;
    }

    private static void spfa(){
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dist, INF);
        dist[1] = 0;
        used[1] = true;
        q.add(1);
        while(q.size() > 0){
            int t = q.peek();
            q.poll();
            used[t] = false;
            for(int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                if(dist[j] > dist[t] + w[i]){
                    dist[j] = dist[t] + w[i];
                    if(!used[j]){
                        used[j] = true;
                        q.add(j);
                    }
                }
            }
        }
        if(dist[n] == INF) System.out.println("impossible");
        else System.out.println(dist[n]);
    }
}