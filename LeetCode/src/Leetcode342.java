class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 1) return true;
        if(n == 0) return false;
        if(n % 4 != 0) return false;
        return isPowerOfFour(n / 4);
    }
}

class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
    }
}