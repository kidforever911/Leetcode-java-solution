import java.io.*;
import java.util.*;

public class Main{
    private static int N = 100010, M = 2 * N;
    private static int n;
    private static int[] h = new int[N];
    private static int[] e = new int[M];
    private static int[] ne = new int[M];
    private static int idx = 0;
    private static boolean[] visited = new boolean[N];
    private static int answer = Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        Arrays.fill(h, -1);
        for(int i = 0; i < n - 1; i ++){
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
            add(b, a);
        }
        dfs(1);
        System.out.println(answer);
    }
    private static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }
    //以u为根的子树中点的数量
    private static int dfs(int u){
        visited[u] = true;
        //sum记录以u为根的子树中点的数量总和
        //result记录去除某点后子树中点数的最大值
        int sum = 1, result = 0;
        for(int i = h[u]; i != -1; i = ne[i]){
            int j = e[i];
            if(!visited[j]){
                int s = dfs(j);
                result = Math.max(result, s);
                sum += s;
            }
        }
        result = Math.max(result, n - sum);
        answer = Math.min(answer, result);
        return sum;
    }
}