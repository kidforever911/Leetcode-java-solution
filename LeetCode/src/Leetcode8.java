class Solution {
    public int myAtoi(String s) {
        int k = 0;
        while(k < s.length() && s.charAt(k) == ' '){
            k++;
        }
        if(k == s.length()) return 0;
        int sign = 1;
        if(s.charAt(k) == '-'){
            sign = -1;
            k ++;
        }else if(s.charAt(k) == '+'){
            k ++;
        }

        int r = 0;
        while(k < s.length() && s.charAt(k) >= '0' && s.charAt(k) <= '9'){
            int x = s.charAt(k) - '0';

            if(sign > 0 && r > (Integer.MAX_VALUE - x) / 10) return Integer.MAX_VALUE;
            if(sign < 0 && -r < (Integer.MIN_VALUE + x) / 10) return Integer.MIN_VALUE;
            if(-r * 10 - x == Integer.MIN_VALUE) return Integer.MIN_VALUE;
            r = r * 10 + x;
            k ++;
            if(r > Integer.MAX_VALUE) break;
        }
        r = sign * r;
        return r;
    }
}

class Solution {
    public int myAtoi(String s) {
        int k = 0;
        while(k < s.length() && s.charAt(k) == ' '){
            k++;
        }
        if(k == s.length()) return 0;
        int sign = 1;
        if(s.charAt(k) == '-'){
            sign = -1;
            k ++;
        }else if(s.charAt(k) == '+'){
            k ++;
        }

        long r = 0;
        while(k < s.length() && s.charAt(k) >= '0' && s.charAt(k) <= '9'){
            r = r * 10 + s.charAt(k) - '0';
            k ++;
            if(r > Integer.MAX_VALUE) break;
        }
        r = sign * r;
        if(r > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(r < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)r;
    }
}