import java.io.*;
import java.util.*;

public class Main{
    private static int N = 100010, M = 2 * N;
    private static int n, m, idx;
    private static int[] d = new int[N];
    private static int[] h = new int[N];
    private static int[] e = new int[M];
    private static int[] ne = new int[M];
    private static int[] q = new int[N];
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h, -1);
        while(m -- > 0){
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
            d[b] ++;
        }
        if(topSort()){
            for(int i = 0; i < n; i ++){
                System.out.print(q[i] + " ");
            }
        }else{

            System.out.print("-1");
        }
    }

    private static boolean topSort(){
        int hh = 0;
        int tt = -1;
        for(int i = 1; i <= n; i ++){
            if(d[i] == 0){
                q[++ tt] = i;
            }
        }
        while(tt >= hh){
            int head = q[hh ++];
            for(int i = h[head]; i != -1; i = ne[i]){
                int j = e[i];
                d[j] --;
                if(d[j] == 0){
                    q[++ tt] = j;
                }
            }

        }
        return tt == n - 1;
    }

    private static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;

    }

}