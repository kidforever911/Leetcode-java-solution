class Solution {
    int count = 0;
    public int countEven(int num) {
        if(num == 0) return 0;
        for(int i = 1; i <= num; i ++){
            getDigit(i);
        }
        return count;
    }

    private void getDigit(int x){
        int sum = 0;
        while(x != 0){
            sum += x % 10;
            x /= 10;
        }
        if(sum % 2 == 0){
            count ++;
        }
    }
}