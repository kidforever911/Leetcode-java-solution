class Solution {
    public int minSteps(String s, String t) {
        int[] record = new int[26];
        for(char c : t.toCharArray()) {
            int tidx = c - 'a';
            record[tidx] ++;
        }
        for(char c : s.toCharArray()) {
            int sidx = c - 'a';
            if(record[sidx] > 0) {
                record[sidx] --;
            }
        }
        int result = 0;
        for(int i = 0; i < 26; i ++) {
            result += record[i];
        }
        return result;
    }
}