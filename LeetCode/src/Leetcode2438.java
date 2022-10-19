class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> record = new ArrayList<>();
        int MOD = (int)(1e9 + 7);
        for(int i = 29; i >= 0; i --) {
            if(n >= (1 << i)) {
                record.add(1 << i);
                n -= (1 << i);
            }
        }
        Collections.reverse(record);
        int[] result = new int[queries.length];
        Arrays.fill(result, 1);
        for(int i = 0; i < queries.length; i ++) {
            for(int j = queries[i][0]; j <= queries[i][1]; j ++) {
                result[i] = (int)(1l * result[i] * record.get(j) % MOD);
            }
        }
        return result;
    }
}