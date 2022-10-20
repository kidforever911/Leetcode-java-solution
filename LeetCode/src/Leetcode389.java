class Solution {
    public char findTheDifference(String s, String t) {
        int[] counts = new int[26];
        int[] countt = new int[26];
        for(char c : s.toCharArray()) {
            counts[c - 'a'] ++;
        }
        for(char c : t.toCharArray()) {
            countt[c - 'a'] ++;
        }
        for(int i = 0; i < counts.length; i ++) {
            if(counts[i] != countt[i]) {
                return (char)(i + 'a');
            }
        }
        return ' ';
    }
}

class Solution {
    public char findTheDifference(String s, String t) {
        int result = 0;
        for(char c : s.toCharArray()) {
            result ^= (c - 'a');
        }
        for(char c : t.toCharArray()) {
            result ^= (c - 'a');
        }
        return (char)(result + 'a');
    }
}