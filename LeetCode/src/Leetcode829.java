class Solution {
    public int consecutiveNumbersSum(int n) {
        n *= 2;
        int result = 0;
        for(int b = 1; b * b <= n; b ++) {
            if(n % b == 0) {
                if((n / b - b + 1) % 2 == 0) {
                    result ++;
                }
            }
        }
        return result;
    }
}