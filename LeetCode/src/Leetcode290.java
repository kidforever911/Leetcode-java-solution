import java.util.HashMap;
import java.util.Map;

public class Leetcode290 {
    class Solution {
        public boolean wordPattern(String pattern, String str) {
            String[] letter_str = str.split(" ");
            char[] letter_pattern = pattern.toCharArray();
            if(letter_str.length != letter_pattern.length) return false;
            Map<Character, String> record = new HashMap<>();
            for(int i = 0; i < letter_pattern.length; i++){

                if(record.containsKey(letter_pattern[i]) && !record.get(letter_pattern[i]).equals(letter_str[i])){
                    return false;
                }else if(!record.containsKey(letter_pattern[i]) && record.containsValue(letter_str[i])){
                    return false;
                }else{
                    record.put(letter_pattern[i], letter_str[i]);
                }
            }
            return true;
        }
    }
}
