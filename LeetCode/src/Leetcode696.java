class Solution {
    public int countBinarySubstrings(String s) {
        int result = 0, last = 0;
        for(int i = 0; i < s.length(); i ++) {
            int j = i + 1;
            while(j < s.length() && s.charAt(i) == s.charAt(j)) j ++;
            int cur = j - i;
            i = j - 1;
            result += Math.min(cur, last);
            last = cur;
        }
        return result;
    }
}