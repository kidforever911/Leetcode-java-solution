class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int result = Integer.MAX_VALUE;
        int maxLength = 0;
        for(int i = 0; i < logs.length; i ++) {
            int diff = i == 0 ? (logs[i][1] - 0) : (logs[i][1] - logs[i - 1][1]);
            if(diff > maxLength) {
                result = logs[i][0];
                maxLength = diff;
            } else if(diff == maxLength) {
                result = Math.min(result, logs[i][0]);
            }
        }
        return result;
    }
}