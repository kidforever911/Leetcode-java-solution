class Solution {
    public int titleToNumber(String columnTitle) {
        if(columnTitle.length() == 0) return 0;
        int result = 0;
        int n = columnTitle.length();
        for(int i = 0, p = 26; i < n - 1; i ++, p *= 26){
            result += p;
        }
        int temp = 0;
        for(char c : columnTitle.toCharArray()){
            temp = temp * 26 + c - 'A';
        }
        return result + temp + 1;
    }
}