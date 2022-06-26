class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if(n == 0) return 0;
        int left = 0, right = n;
        while(left < right) {
            int mid = left + right + 1 >> 1;
            if(citations[n - mid] >= mid) left = mid;
            else right = mid - 1;
        }
        return left;
    }
}