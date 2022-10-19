class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for(int i = 0; i <= (num + 1 / 2); i ++) {
            int sum = i;
            int temp = 0;
            int copy = i;
            while(copy != 0) {
                temp = temp * 10 + copy % 10;
                copy /= 10;
            }
            sum += temp;
            if(sum == num) {
                return true;
            }
        }
        return false;
    }
}