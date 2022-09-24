class Solution {
    public int concatenatedBinary(int n) {
        int MOD = (int) (1e9 + 7);
        long result = 0;
        for(int i = 1; i <= n; i ++) {
            result = ((result << Integer.toBinaryString(i).length()) + i) % MOD;
        }
        return (int)result;
    }
}

class Solution {
    public int concatenatedBinary(int n) {
        int MOD = (int) (1e9 + 7);
        long result = 0;
        for(int i = 1; i <= n; i ++) {
            result = ((result << getLength(i)) + i) % MOD;
        }
        return (int)result;
    }

    private int getLength(int x) {
        int count = 0;
        while(x != 0) {
            count ++;
            x >>= 1;
        }
        return count;
    }
}