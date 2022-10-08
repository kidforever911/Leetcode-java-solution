class Solution {
    public boolean canMeasureWater(int a, int b, int c) {
        if(a + b < c) return false;
        return c == 0 || c % gcd(a, b) == 0;
    }
    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}