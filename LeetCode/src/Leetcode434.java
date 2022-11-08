class Solution {
    public int countSegments(String s) {
        if(s.length() == 0) return 0;
        int result = 0;
        for(int i = 0, j = 0; i < s.length(); i ++) {
            if(s.charAt(i) == ' ') continue;
            j = i;
            while(j < s.length() && s.charAt(j) != ' ') j ++;
            result ++;
            i = j - 1;
        }
        return result;
    }
}