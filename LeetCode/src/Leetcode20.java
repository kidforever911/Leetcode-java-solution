import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        char[] letters = s.toCharArray();
        Stack<Character> record = new Stack<>();
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == '(' || letters[i] == '[' || letters[i] == '{') {
                record.push(letters[i]);
            } else {
                if (record.size() == 0) {
                    return false;
                }
                char c = record.pop();
                char match;
                if (letters[i] == ')') {
                    match = '(';
                } else if (letters[i] == ']') {
                    match = '[';
                } else {
                    assert letters[i] == '}';
                    match = '{';
                }
                if (c != match) {
                    return false;
                }
            }
        }
        if (record.size() != 0) {
            return false;
        }
        return true;
    }
}


class Solution {
    public boolean isValid(String s) {
        Stack<Character> record = new Stack<>();
        char[] letters = s.toCharArray();
        for(int i = 0; i < letters.length; i ++){
            if(letters[i] == '(' || letters[i] == '{' || letters[i] == '[') record.push(letters[i]);
            else{
                if(!record.isEmpty() && Math.abs(record.peek() - letters[i]) <= 2) record.pop();
                else return false;
            }

        }
        return record.isEmpty();
    }
}

class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return false;
        char[] letters = s.toCharArray();
        Stack<Character> record = new Stack<>();
        for(int i = 0; i < letters.length; i ++){
            if(letters[i] == '{' || letters[i] == '[' || letters[i] == '('){
                record.add(letters[i]);
            }else{
                if(record.size() == 0) return false;
                if(Math.abs(letters[i] - record.pop()) > 2) return false;
            }
        }
        return record.isEmpty();
    }
}
