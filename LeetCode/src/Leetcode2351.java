class Solution {
    public char repeatedCharacter(String s) {
        int[] count = new int[26];
        char result = ' ';
        for(char c : s.toCharArray()) {
            count[c - 'a'] ++;
            if(count[c - 'a'] == 2) {
                result = c;
                break;
            }
        }
        return result;
    }
}