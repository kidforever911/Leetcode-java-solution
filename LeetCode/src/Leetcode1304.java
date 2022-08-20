class Solution {
    public int[] sumZero(int n) {
        int start = 1;
        int[] result = new int[n];
        int count = 0;
        for(int i = 0; i < result.length; i ++) {
            result[i] = start;
            count ++;
            if(count == 2) {
                result[i] = -start;
                count = 0;
                start += 1;
            }
        }
        if(n % 2 == 1) result[result.length - 1] = 0;
        return result;
    }
}