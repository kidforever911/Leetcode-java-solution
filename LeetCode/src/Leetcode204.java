class Solution {
    public int countPrimes(int n) {
        if(n == 0) return 0;
        boolean[] isPrime = new boolean[n + 1];
        int result = 0;
        for(int i = 2; i < n; i ++){
            if(!isPrime[i]){
                result ++;
            }
            for(int j = 2; j * i < n; j ++){
                isPrime[i * j] = true;
                if(i % j == 0) break;
            }
        }
        return result;
    }
}