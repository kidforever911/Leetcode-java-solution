import java.util.Stack;

public class Leetcode20 {
    class Solution {
        public boolean isValid(String s) {
            char[] letters = s.toCharArray();
            Stack<Character> record = new Stack<>();
            for(int i = 0; i < letters.length; i++){
                if(letters[i] == '(' || letters[i] == '[' || letters[i] == '{'){
                    record.push(letters[i]);
                }else{
                    if(record.size() == 0){
                        return false;
                    }
                    char c = record.pop();
                    char match;
                    if(letters[i] == ')'){
                        match = '(';
                    }else if(letters[i] == ']'){
                        match = '[';
                    }else{
                        assert letters[i] == '}';
                        match = '{';
                    }
                    if(c != match){
                        return false;
                    }
                }
            }
            if(record.size() != 0){
                return false;
            }
            return true;
        }
    }
}
