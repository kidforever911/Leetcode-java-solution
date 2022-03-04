import java.io.*;
import java.util.*;

public class Main{
    private static int N = 100010, M = 2 * N;
    private static int n, m, idx;
    private static int[] h = new int[N];
    private static int[] ne = new int[M];
    private static int[] e = new int[M];
    private static int[] color = new int[N];
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h, -1);
        while(m -- > 0){
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
            add(b, a);
        }
        boolean flag = true;
        for(int i = 1; i <= n; i ++){
            if(color[i] == 0){
                if(!dfs(i, 1)){
                    flag = false;
                    break;
                }
            }
        }
        if(flag) System.out.println("Yes");
        else System.out.println("No");
        return;
    }

    private static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }

    private static boolean dfs(int index, int c){
        color[index] = c;
        for(int i = h[index]; i != -1; i = ne[i]){
            int j = e[i];
            if(color[j] == 0){
                if(!dfs(j, 3 - c)) return false;
            }
            else if(color[j] == c) return false;
        }
        return true;
    }

}