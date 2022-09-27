class Solution {
    public int smallestEvenMultiple(int n) {
        int result = 0;
        for(int i = n; i <= 2 * n; i ++) {
            if(i % 2 == 0 && i % n == 0) {
                result = i;
                break;
            }
        }
        return result;
    }
}

class Solution {
    public int smallestEvenMultiple(int n) {
        if(n % 2 == 1) return n * 2;
        return n;
    }
}