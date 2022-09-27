class Solution {
    public int longestContinuousSubstring(String s) {
        int result = 0;
        for(int slow = 0, fast = 0; fast < s.length(); fast ++) {
            if((s.charAt(fast) - s.charAt(slow)) != fast - slow) {
                slow = fast;
            }
            result = Math.max(result, fast - slow + 1);
        }
        return result;
    }
}