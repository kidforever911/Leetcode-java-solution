import java.util.*;
import java.io.*;

public class Main{
    private static int N = 6010;
    private static int n;
    private static int[] happy = new int[N];
    private static int[][] f = new int[N][2];
    private static int[] h = new int[N];
    private static int[] e = new int[2 * N];
    private static int[] ne = new int[2 * N];
    private static int idx = 0;
    private static boolean[] hasFather = new boolean[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        for(int i = 1; i <= n; i ++) happy[i] = in.nextInt();
        Arrays.fill(h, -1);
        for(int i = 0; i < n - 1; i ++) {
            int a = in.nextInt();
            int b = in.nextInt();
            add(b, a);
            hasFather[a] = true;
        }
        int root = 1;
        while(hasFather[root]) root ++;
        dfs(root);
        System.out.println(Math.max(f[root][0], f[root][1]));
    }

    private static void dfs(int u) {
        f[u][1] = happy[u];
        for(int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            dfs(j);
            f[u][0] += Math.max(f[j][0], f[j][1]);
            f[u][1] += f[j][0];
        }
    }

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }
}