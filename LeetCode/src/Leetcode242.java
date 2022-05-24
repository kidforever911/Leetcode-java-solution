import java.util.Arrays;


class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i) - 'a']--;
            if (freq[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] letter_s = s.toCharArray();
        char[] letter_t = t.toCharArray();
        Arrays.sort(letter_s);
        Arrays.sort(letter_t);
        return Arrays.equals(letter_s, letter_t);
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> a = new HashMap<>();
        HashMap<Character, Integer> b = new HashMap<>();
        for(char c : s.toCharArray()){
            a.put(c, a.getOrDefault(c, 0) + 1);
        }
        for(char c : t.toCharArray()){
            b.put(c, b.getOrDefault(c, 0) + 1);
        }
        return a.equals(b);
    }
}

