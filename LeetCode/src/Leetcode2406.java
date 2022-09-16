class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        int endIndex = 0;
        for(int i = 0; i < n; i ++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int result = 0;
        for(int i = 0; i < n; i ++) {
            result ++;
            if(start[i] > end[endIndex]) {
                result --;
                endIndex ++;
            }
        }
        return result;
    }
}