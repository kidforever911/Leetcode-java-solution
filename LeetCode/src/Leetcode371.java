class Solution {
    public int getSum(int a, int b) {
        if(a == 0) return b;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return getSum(carry, sum);
    }
}