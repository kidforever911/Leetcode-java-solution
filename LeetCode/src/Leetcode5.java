//时间复杂度O（n2）
class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for(int i = 0; i < s.length(); i ++){
            //考虑中间字符不考虑的回文子串
            int left = i - 1, right = i + 1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left --;
                right ++;
            }
            if(result.length() < right - 1 - left - 1 + 1){
                result = s.substring(left + 1, right);
            }
            //考虑中间字符考虑的回文子串
            left = i;
            right = i + 1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left --;
                right ++;
            }
            if(result.length() < right - 1 - left - 1 + 1){
                result = s.substring(left + 1, right);
            }
        }
        return result;
    }
}