class Solution {
    public int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        for(int x : nums) {
            if(x == firstMax || x == secondMax || x == thirdMax) continue;
            if(x > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = x;
            } else if(x > secondMax) {
                thirdMax = secondMax;
                secondMax = x;
            } else if(x > thirdMax) {
                thirdMax = x;
            }
        }
        return thirdMax == Long.MIN_VALUE ? (int)firstMax : (int)thirdMax;
    }
}