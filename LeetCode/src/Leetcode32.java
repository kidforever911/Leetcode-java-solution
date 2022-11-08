import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        if(s.isEmpty()) return 0;
        Stack<Integer> record = new Stack<>();
        char[] letters = s.toCharArray();
        int start = -1;
        int result = 0;
        for(int i = 0; i < letters.length; i ++){
            if(letters[i] == '('){
                record.push(i);
            }else{
                if(record.size() > 0){
                    record.pop();
                    if(record.size() > 0){
                        result = Math.max(result, i - record.peek());
                    }else{
                        result = Math.max(result, i - start);
                    }
                }else{
                        start = i;
                }
            }
        }
        return result;
    }
}