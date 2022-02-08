import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public long smallestNumber(long num) {
        long result = 0;
        if(num == 0) return result;
        List<Integer> record = new ArrayList<>();
        int sign = 1;
        if(num < 0) sign = -1;
        num = Math.abs(num);
        while(num != 0){
            record.add((int)(num % 10));
            num /= 10;
        }
        int[] digits = new int[record.size()];
        int index = 0;
        for(int nums : record){
            digits[index] = nums;
            // System.out.println(nums + " " + digits[index]);
            index ++;
        }
        Arrays.sort(digits);
        if(sign > 0){
            int k = 0;
            while(k < digits.length && digits[k] == 0){
                k ++;
            }
            if(k != 0) result += digits[k];

            for(int i = 0; i < digits.length; i ++){
                if(k == 0){
                    result = result * 10 + digits[i];
                }else{
                    if(i != k){
                        result = result * 10 + digits[i];
                    }
                }
            }
            return result;
        }
        if(sign < 0){
            for(int i = digits.length - 1; i >= 0; i --){
                result = result * 10 + digits[i];
            }
            return sign * result;
        }
        return result;

    }
}