class Solution {
    public int integerBreak(int n) {
        if(n <= 3) return 1 * (n - 1);
        int result = 1;
        if(n % 3 == 1){
            result *= 4;
            n -= 4;
        }
        if(n % 3 == 2){
            result *= 2;
            n -= 2;
        }
        while(n > 0){
            result *= 3;
            n -= 3;
        }
        return result;
    }
}