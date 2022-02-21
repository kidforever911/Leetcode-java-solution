import java.io.*;
import java.util.*;

public class Main{
    private static int N = 100010, M = 2 * N;
    private static int n;
    private static int m;
    private static int[] h = new int[N];
    private static int[] e = new int[M];
    private static int[] ne = new int[M];
    private static int idx = 0;
    private static int[] q = new int[N];
    private static int[] d = new int[N];
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h, -1);
        Arrays.fill(d, -1);
        for(int i = 0; i < m; i ++){
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
        }
        int answer = bfs();
        System.out.println(answer);
    }

    private static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }

    private static int bfs(){
        d[1] = 0;
        q[0] = 1;
        int hh = 0, tt = 0;
        while(hh <= tt){
            int head = q[hh ++];
            for(int i = h[head]; i != -1; i = ne[i]){
                int j = e[i];
                if(d[j] == -1){
                    d[j] = d[head] + 1;
                    q[++tt] = j;
                }
            }
        }
        return d[n];
    }
}