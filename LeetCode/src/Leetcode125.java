class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return false;
        for(int i = 0, j = s.length() - 1; i < j; i ++, j --){
            while(i < j && !check(s.charAt(i))) i ++;
            while(i < j && !check(s.charAt(j))) j --;
            if(i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
        }
        return true;
    }

    private boolean check(char c){
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }
}