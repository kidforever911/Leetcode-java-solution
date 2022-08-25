class Solution {
    public int minInsertions(String s) {
        int right = 0, result = 0;
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == '(') {
                right += 2;
                if(right % 2 == 1) {
                    right --;
                    result ++;
                }
            } else {
                right --;
                if(right < 0) {
                    result ++;
                    right += 2;
                }
            }
        }
        return result + right;
    }
}