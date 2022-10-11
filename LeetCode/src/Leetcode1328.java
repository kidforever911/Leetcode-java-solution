class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";
        StringBuilder result = new StringBuilder(palindrome);
        for(int i = 0; i < palindrome.length(); i ++) {
            if(palindrome.charAt(i) != 'a' && (palindrome.length() % 2 == 0 || i != palindrome.length() / 2)) {
                result.setCharAt(i, 'a');
                return result.toString();
            }
        }
        result.setCharAt(result.length() - 1, 'b');
        return result.toString();
    }
}