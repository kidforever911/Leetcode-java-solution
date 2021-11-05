class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i --){
            if(digits[i] < 9){
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}


class Solution {
    public int[] plusOne(int[] digits) {
        int m = digits.length;
        if(m == 0) return digits;
        int index = m - 1;
        int t = 1;
        while(index >= 0){
            t += digits[index];
            digits[index] = t % 10;
            t /= 10;
            index --;
        }
        if(t > 0){
            int[] result = new int[m + 1];
            result[0] = t;
            return result;
        }

        return digits;
    }
}