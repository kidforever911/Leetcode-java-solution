import java.util.Stack;


class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> record = new Stack<>();
        int a = 0;
        int b = 0;
        for (String s : tokens) {
            if (s.equals("+")) {
                a = record.pop();
                b = record.pop();
                record.push(a + b);
            } else if (s.equals("-")) {
                b = record.pop();
                a = record.pop();
                record.push(a - b);
            } else if (s.equals("*")) {
                a = record.pop();
                b = record.pop();
                record.push(a * b);
            } else if (s.equals("/")) {
                b = record.pop();
                a = record.pop();
                record.push(a / b);
            } else {
                record.push(Integer.parseInt(s));
            }
        }
        return record.pop();
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0) return 0;
        Stack<Integer> record = new Stack<>();
        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int b = record.pop();
                int a = record.pop();
                if(s.equals("+")) a += b;
                else if(s.equals("-")) a -= b;
                else if(s.equals("*")) a *= b;
                else a /= b;
                record.push(a);
            }else{
                record.push(Integer.parseInt(s));
            }
        }
        return record.peek();
    }
}

