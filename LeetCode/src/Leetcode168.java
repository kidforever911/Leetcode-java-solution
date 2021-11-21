class Solution {
    public String convertToTitle(int columnNumber) {
        if(columnNumber == 0) return "";
        int k = 1;
        for(long p = 26; columnNumber > p; p *= 26){
            columnNumber -= p;
            k ++;
        }

        columnNumber --;
        String result = "";
        while(k -- > 0){
            result += (char)(columnNumber % 26 + 'A');
            columnNumber /= 26;
        }
        return new StringBuilder(result).reverse().toString();
    }
}