class Solution {
    private int N = 2010;
    private int[][] f = new int[N][N];
    HashMap<Integer, Integer> record;
    public boolean canCross(int[] stones) {
        if(stones.length == 0) return false;
        for(int i = 0; i < f.length; i ++) {
            Arrays.fill(f[i], -1);
        }
        f[0][1] = 1;
        record = new HashMap<>();
        for(int i = 0; i < stones.length; i ++) {
            record.put(stones[i], i);
        }
        int n = stones.length;
        for(int i = 0; i <= n; i ++) {
            if(dp(n - 1, i, stones) > 0) {
                return true;
            }
        }
        return false;
    }

    private int dp(int i, int j, int[] stones) {
        if(f[i][j] != -1) return f[i][j];
        f[i][j] = 0;
        for(int l = Math.max(1, j - 1); l <= j + 1; l ++) {
            int x = stones[i] - l;
            if(record.containsKey(x)) {
                int k = record.get(x);
                if(dp(k, l, stones) > 0) {
                    f[i][j] = 1;
                    break;
                }
            }
        }
        return f[i][j];
    }
}