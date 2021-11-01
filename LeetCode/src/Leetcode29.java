import java.util.ArrayList;
import java.util.List;

class Solution {
    public int divide(int dividend, int divisor) {
        List<Long> exp = new ArrayList<>();
        boolean isMinus = false;
        if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) isMinus = true;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        for(long i = b; i <= a; i = i + i){
            exp.add(i);
        }
        long result = 0;
        for(int i = exp.size() - 1; i >= 0; i --){
            if(a >= exp.get(i)){
                a -= exp.get(i);
                result += 1l << i;
            }
        }
        if(isMinus) result = -result;
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) result = Integer.MAX_VALUE;
        return (int) result;
    }
}