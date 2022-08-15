class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] w = new long[n];
        for(int i = 0; i < n; i ++) {
            w[edges[i]] += i;
        }
        int result = 0;
        for(int i = 1; i < n; i ++) {
            if(w[i] > w[result]) {
                result = i;
            }
        }
        return result;
    }
}