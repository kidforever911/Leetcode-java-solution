public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if(n == 0) return 0;
        int result = 0;
        for(int i = 0; i < 32; i ++)
            result += n >> i & 1;
        return result;
    }
}