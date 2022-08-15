class Solution {
    private int n;
    private List<List<Integer>> result;
    private List<Integer> record;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result = new ArrayList<>();
        record = new ArrayList<>();
        n = graph.length;
        dfs(0, graph);
        return result;
    }

    private void dfs(int u, int[][] graph) {
        record.add(u);
        if(u == n - 1) result.add(new ArrayList<>(record));
        for(int v : graph[u]) dfs(v, graph);
        record.remove(record.size() - 1);
        return;
    }
}