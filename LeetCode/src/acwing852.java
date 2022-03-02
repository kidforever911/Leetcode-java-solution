import java.io.*;
import java.util.*;

public class Main{
    private static int N = 2010, M = 10010;
    private static int n, m, idx;
    private static int[] h = new int[N];
    private static int[] e = new int[M];
    private static int[] ne = new int[M];
    private static int[] w = new int[M];
    private static int[] dist = new int[N];
    private static int[] count = new int[N];
    private static boolean[] used = new boolean[N];

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
        if(spfa()) System.out.println("Yes");
        else System.out.println("No");
        return;
    }

    private static void add(int a, int b, int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx ++;
    }

    private static boolean spfa(){
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i ++){
            q.add(i);
            used[i] = true;
        }

        while(q.size() > 0){
            int t = q.peek();
            q.poll();
            used[t] = false;
            for(int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                if(dist[j] > dist[t] + w[i]){
                    dist[j] = dist[t] + w[i];
                    count[j] = count[t] + 1;
                    if(count[j] >= n) return true;
                    if(! used[j]){
                        q.add(j);
                        used[j] = true;
                    }
                }

            }
        }
        return false;
    }
}


