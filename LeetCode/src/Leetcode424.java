class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 0) return 0;
        int result = 0;
        for(char c = 'A'; c <= 'Z'; c ++) {
            for(int slow = 0, fast = 0, count = 0; fast < s.length(); fast ++) {
                if(s.charAt(fast) == c) count ++;
                while(fast - slow + 1 - count > k) {
                    if(s.charAt(slow) == c) count --;
                    slow ++;
                }
                result = Math.max(result, fast - slow + 1);
            }
        }
        return result;
    }
}