//贪心+排序（nlogn）
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        int n = costs.length;
        int result = 0;
        for(int i = 0; i < n; i ++) {
            if(i < n / 2) {
                result += costs[i][0];
            } else {
                result += costs[i][1];
            }
        }
        return result;
    }
}

//dp（n2）
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int[][] f = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i ++) {
            f[i][0] = f[i - 1][0] + costs[i - 1][0];
        }
        for(int i = 1; i <= n; i ++) {
            f[0][i] = f[0][i - 1] + costs[i - 1][1];
        }
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                f[i][j] = Math.min(f[i - 1][j] + costs[i + j - 1][0], f[i][j - 1] + costs[i + j - 1][1]);
            }
        }
        return f[n][n];
    }
}