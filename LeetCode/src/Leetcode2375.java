class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        char[] record = new char[n + 1];
        for(int i = 0; i <= n; i ++) {
            record[i] = (char)(i + 1 + '0');
        }
        for(int i = 0; i < n; i ++) {
            int j = i;
            char c = pattern.charAt(i);
            while(j < n && pattern.charAt(j) == c) j ++;
            if(c == 'D') reverse(record, i, j);
            i = j - 1;
        }
        return String.valueOf(record);
    }
    private void reverse(char[] record, int x, int y) {
        while(x < y) {
            char t = record[x];
            record[x ++] = record[y];
            record[y --] = t;
        }
    }
}