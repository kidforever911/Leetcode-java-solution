class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        if(n == 0) return result;
        for(int i = 1; i <= 9; i ++) dfs(i, n, result);
        return result;
    }
    private void dfs(int cur, int n, List<Integer> result) {
        if(cur <= n) result.add(cur);
        else return;
        for(int i = 0; i <= 9; i ++) {
            dfs(cur * 10 + i, n, result);
        }
        return;
    }
}