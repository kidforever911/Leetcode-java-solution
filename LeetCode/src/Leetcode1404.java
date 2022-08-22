class Solution {
    public int numSteps(String s) {
        StringBuilder str = new StringBuilder(s);
        int result = 0;
        while(str.length() != 1) {
            if(str.charAt(str.length() - 1) == '1') {
                int idx = str.length() - 1;
                while(idx >= 0 && str.charAt(idx) == '1') {
                    str.setCharAt(idx, '0');
                    idx --;
                }
                if(idx < 0) {
                    str.insert(0, '1');
                } else {
                    str.setCharAt(idx, '1');
                }
            } else {
                str = str.deleteCharAt(str.length() - 1);
            }
            result ++;
        }
        return result;
    }
}

class Solution {
    public int numSteps(String s) {
        int result = 0;
        int carry = 0;
        for(int i = s.length() - 1; i > 0; i --) {
            if(s.charAt(i) - '0' + carry == 1) {
                carry = 1;
                result += 2;
            } else {
                result ++;
            }
        }
        return result + carry;
    }
}