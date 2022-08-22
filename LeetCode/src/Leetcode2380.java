class Solution {
    public int secondsToRemoveOccurrences(String s) {
        if(s.length() == 0) return 0;
        int result = 0;
        boolean flag = true;
        StringBuilder str = new StringBuilder(s);
        while(flag) {
            flag = false;
            for(int i = 0; i < str.length() - 1; i ++) {
                if(str.charAt(i) == '0' && str.charAt(i + 1) == '1') {
                    str.setCharAt(i, '1');
                    str.setCharAt(i + 1, '0');
                    flag = true;
                    i = i + 1;
                }
            }
            if(flag) result ++;
        }
        return result;
    }
}

class Solution {
    public int secondsToRemoveOccurrences(String s) {
        if(s.length() == 0) return 0;
        int result = 0;
        while(s.indexOf("01") >= 0) {
            s = s.replace("01", "10");
            result ++;
        }
        return result;
    }
}