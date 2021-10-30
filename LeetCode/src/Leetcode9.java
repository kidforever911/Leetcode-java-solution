class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        String s = Integer.toString(x);
        String res = new StringBuilder(s).reverse().toString();
        return s.equals(res);
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;;
        long res = 0;
        int temp = x;
        while (temp > 0){
            res = res * 10 + temp % 10;
            temp = temp / 10;
        }
        return x == res;
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)) return false;
        int res = 0;
        while(res <= x){
            res = res * 10 + x % 10;
            if(res == x || res == x / 10) return true;
            x = x / 10;
        }
        return false;
    }
}