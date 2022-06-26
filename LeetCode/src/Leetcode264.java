class Solution {
    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        result[0] = 1;
        for(int i = 0, j = 0, k = 0, index = 1; index < n; index ++) {
            int t = Math.min(2 * result[i], Math.min(3 * result[j], 5 * result[k]));
            result[index] = t;
            if(t == 2 * result[i]) i ++;
            if(t == 3 * result[j]) j ++;
            if(t == 5 * result[k]) k ++;
        }
        return result[n - 1];
    }
}