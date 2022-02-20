class Solution {
    public long[] sumOfThree(long num) {
        long[] result = null;
        if(num % 3 != 0){
            result = new long[0];
            return result;
        }
        result = new long[3];
        result[0] = num / 3 - 1;
        result[1] = num / 3;
        result[2] = num / 3 + 1;
        return result;
    }
}