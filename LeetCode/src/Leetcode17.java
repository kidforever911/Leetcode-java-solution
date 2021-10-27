import java.util.ArrayList;
import java.util.List;

public class Leetcode17 {
    class Solution {
        String letterMap[] = {
                " ",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if(digits.length() == 0) return result;
            findCombinations(digits, 0, "", result);
            return result;
        }
        private void findCombinations(String digits, int index, String record, List<String> result){
            if(index == digits.length()){
                result.add(record);
                return;
            }
            char c = digits.charAt(index);
            String letters = letterMap[c - '0'];
            for(int i = 0; i < letters.length(); i++){
                findCombinations(digits, index + 1, record + letters.charAt(i), result);
            }
        }
    }
}
