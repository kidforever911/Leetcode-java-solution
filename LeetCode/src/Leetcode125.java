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

class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return false;
        int left = 0, right = s.length() - 1;
        while(left < right){
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) left ++;
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) right --;
            if(left < right){
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                left ++;
                right --;
            }
        }
        return true;
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return false;
        int left = 0, right = s.length() - 1;
        while(left < right){
            while(left < right && !check(s.charAt(left))) left ++;
            while(left < right && !check(s.charAt(right))) right --;
            if(left < right){
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                left ++;
                right --;
            }
        }
        return true;
    }

    private boolean check(char c){
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'z'|| c >= 'A' && c <= 'Z';
    }
}