class Solution {
    public String longestDiverseString(int a, int b, int c) {
        String result = "";
        if(a == 0 && b == 0 && c == 0) return result;
        int countA = 0, countB = 0, countC = 0;
        int size = a + b + c;

        for(int i = 0; i < size; i ++){
            //选择a的条件是：a的个数最多且不连续出现3次或者连续出现b达到2次或者连续出现c达到2次；
            if((a >= b && a >= c && countA < 2) || (countB == 2 && a > 0) || (countC == 2 && a > 0)){
                result += 'a';
                countA ++;
                a --;
                countB = 0;
                countC = 0;
                //选择c的条件是：c的个数最多且不连续出现3次或者连续出现a达到2次或者连续出现a达到2次
            }else if ((c >= a && c >= b && countC < 2) || (countB == 2 && c > 0) || (countA == 2 && c > 0)){
                result += 'c';
                countC ++;
                c --;
                countA = 0;
                countB = 0;
                //选择b的条件是：b的个数最多且不连续出现3次或者连续出现a达到2次或者连续出现c达到2次
            }else if ((b >= a && b >= c && countB < 2) || (countA == 2 && b > 0) || (countC == 2 && b > 0)){
                result += 'b';
                countB ++;
                b --;
                countA = 0;
                countC = 0;
            }
        }
        return result;
    }
}