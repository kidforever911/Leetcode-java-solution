class Solution {
    public int minSteps(String s, String t) {
        if(s.length() == 0 && t.length() == 0) return 0;
        int[] records = new int[26];
        int[] recordt = new int[26];
        int result = 0;
        for(int i = 0; i < s.length(); i ++){
            records[s.charAt(i) - 'a'] ++;
        }
        for(int i = 0; i < t.length(); i ++){
            recordt[t.charAt(i) - 'a'] ++;
        }
        for(int i = 0; i < 26; i ++){
            result += Math.abs(recordt[i] - records[i]);
        }
        return result;
    }
}