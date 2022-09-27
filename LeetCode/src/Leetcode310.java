class Solution {
    int[] d1, d2, p1, up;
    ArrayList<Integer>[] graph;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        d1 = new int[n];
        d2 = new int[n];
        p1 = new int[n];
        up = new int[n];
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for(int[] e : edges){
            int a = e[0], b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs1(0, -1);
        dfs2(0, -1);

        int mind = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) mind = Math.min(mind, Math.max(up[i], d1[i]));

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(Math.max(up[i], d1[i]) == mind){
                result.add(i);
            }
        }
        return result;
    }

    void dfs1(int u, int father){
        for(int e : graph[u]){
            if(e != father){
                dfs1(e, u);
                int d =  d1[e] + 1;
                if(d >= d1[u]){
                    d2[u] = d1[u];
                    d1[u] = d;
                    p1[u] = e;
                }
                else if(d > d2[u]){
                    d2[u] = d;
                }
            }
        }
    }

    void dfs2(int u, int father){

        for(int e : graph[u]){
            if(e != father){
                if(p1[u] == e) up[e] = Math.max(d2[u], up[u]) + 1;
                else up[e] = Math.max(d1[u], up[u]) + 1;
                dfs2(e, u);
            }
        }
    }
}