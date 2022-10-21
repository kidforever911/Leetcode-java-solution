class Solution {
    public int longestPalindrome(String s) {
        if(s.length() == 1) return 1;
        HashMap<Character, Integer> record = new HashMap<>();
        for(char c : s.toCharArray()) {
            record.put(c, record.getOrDefault(c, 0) + 1);
        }
        int result = 0;
        for(char c : record.keySet()) {
            result += record.get(c) / 2 * 2;
        }
        if(result < s.length()) result ++;
        return result;
    }
}