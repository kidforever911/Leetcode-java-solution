import java.util.HashMap;
import java.util.Map;


class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] letter_str = str.split(" ");
        char[] letter_pattern = pattern.toCharArray();
        if (letter_str.length != letter_pattern.length) return false;
        Map<Character, String> record = new HashMap<>();
        for (int i = 0; i < letter_pattern.length; i++) {

            if (record.containsKey(letter_pattern[i]) && !record.get(letter_pattern[i]).equals(letter_str[i])) {
                return false;
            } else if (!record.containsKey(letter_pattern[i]) && record.containsValue(letter_str[i])) {
                return false;
            } else {
                record.put(letter_pattern[i], letter_str[i]);
            }
        }
        return true;
    }
}

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if (str.length != pattern.length()) return false;
        HashMap<String, Character> wp = new HashMap<>();
        HashMap<Character, String> pw = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char a = pattern.charAt(i);
            String b = str[i];
            if (pw.containsKey(a) && !pw.get(a).equals(b)) return false;
            pw.put(a, b);
            if (wp.containsKey(b) && wp.get(b) != a) return false;
            wp.put(b, a);
        }
        return true;
    }
}
