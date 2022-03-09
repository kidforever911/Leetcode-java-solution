class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        if(queries.length == 0 || queries[0].length == 0 || s.length() == 0) return new int[0];
        int n = queries.length;
        int m = s.length();
        int[] left = new int[m];
        int[] right = new int[m];
        int[] preSum = new int[m + 1];
        int[] result = new int[n];
        char[] letters = s.toCharArray();
        //leftIndex记录每个盘子左边最近的蜡烛位置
        //rightIndex记录每个盘子右边最近的蜡烛位置
        for(int i = 0, j = m - 1, leftIndex = -1, rightIndex = -1; i < m && j >= 0; i ++, j --){
            if(letters[i] == '|') leftIndex = i;
            if(letters[j] == '|') rightIndex = j;
            left[i] = leftIndex;
            right[j] = rightIndex;
            preSum[i + 1] = preSum[i] + (letters[i] == '*'? 1 : 0);
        }
        for (int i = 0; i < n; i++) {
            int a = queries[i][0], b = queries[i][1];
            int c = right[a], d = left[b];
            if (c != -1 && c <= d) result[i] = preSum[d] - preSum[c];
        }
        return result;
    }
}                               