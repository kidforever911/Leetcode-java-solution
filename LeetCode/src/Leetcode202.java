import java.util.HashSet;
import java.util.Set;


class Solution {
    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        int squareSum, remain;
        //检测inLoop中是否存在重复结果
        while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;

        }
        return false;

    }
}

class Solution {
    public boolean isHappy(int n) {
        int fast = get(n), slow = n;
        while(fast != slow){
            fast = get(get(fast));
            slow = get(slow);
        }
        return fast == 1;
    }

    private int get(int x){
        int result = 0;
        while(x > 0){
            result += (x % 10) * (x % 10);
            x /= 10;
        }
        return result;
    }
}

