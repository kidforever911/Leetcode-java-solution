import java.util.Arrays;

class Solution {
    private int N = 100010, M = 2 * N;
    private int n, idx;
    private int[] h = new int[N], e = new int[M], ne = new int[M], f = new int[N];
    private boolean[] visited = new boolean[N];
    public int countHighestScoreNodes(int[] parents) {
        if(parents.length == 0) return 0;
        n = parents.length;
        Arrays.fill(h, -1);
        for(int i = 1; i < n; i ++) add(parents[i], i);
        dfs(0);
        // for(int i = 0; i < n; i ++) System.out.println(f[i]);
        int result = 0;
        long max = 0;
        for(int x = 0; x < n; x ++){
            long cur = 1;
            for(int i = h[x]; i != -1; i = ne[i]) cur *= f[e[i]];
            if(x != 0) cur *= (n - f[x]);
            if(cur > max){
                max = cur;
                result = 1;
            }else if(cur == max){
                result ++;
            }
        }
        return result;
    }

    private void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }

    private int dfs(int index){
        visited[index] = true;
        int sum = 1;
        for(int i = h[index]; i != -1; i = ne[i]){
            int j = e[i];
            if(!visited[j]){
                int s = dfs(j);
                sum += s;
            }
        }
        visited[index] = false;
        f[index] = sum;
        return sum;
    }
}