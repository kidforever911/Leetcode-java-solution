public class Leetcode633 {
    class Solution {
        public boolean judgeSquareSum(int c) {
            if(c < 0) return false;
            long left = 0;
            long right = (long)Math.sqrt(c);
            while(left <= right){
                long result = left * left + right * right;
                if(result == c){
                    return true;
                }else if(result < c){
                    left++;
                }else{
                    right--;
                }
            }
            return false;
        }

    }

}
