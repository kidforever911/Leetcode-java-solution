class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long result = 0l;
        for(long i = 1; cal(n) > target; i *= 10) {
            int cur = (int)(n / i % 10);
            if(cur == 0) continue;
            cur = 10 - cur;
            result += cur * i;
            n += i * cur;
        }
        return result;
    }

    private int cal(long n) {
        int sum = 0;
        while(n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}