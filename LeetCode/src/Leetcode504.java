class Solution {
    public String convertToBase7(int num) {
        boolean isMinus = false;
        if(num < 0) isMinus = true;
        num = Math.abs(num);
        StringBuilder result = new StringBuilder();
        do{
            result.append(num % 7);
            num /= 7;
        }while(num != 0);
        if(isMinus) result.append('-');
        result.reverse();
        return result.toString();
    }
}