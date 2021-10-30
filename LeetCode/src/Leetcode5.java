//time complexity: o(n^2);
class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        if(s.length() == 0) return result;
        for(int i = 0; i < s.length(); i ++){
            int left = i - 1, right = i + 1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left --;
                right ++;
            }
            if(result.length() < right - left - 1){
                result = s.substring(left + 1, right);
            }

            left = i;
            right = i + 1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left --;
                right ++;
            }
            if(result.length() < right - left - 1){
                result = s.substring(left + 1, right);
            }
        }
        return result;
    }
}
