import java.util.Stack;

public class Leetcode150 {
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> record = new Stack<>();
            int a = 0;
            int b = 0;
            for(String s : tokens){
                if(s.equals("+")){
                    a = record.pop();
                    b = record.pop();
                    record.push(a + b);
                }else if(s.equals("-")){
                    b = record.pop();
                    a = record.pop();
                    record.push(a - b);
                }else if(s.equals("*")){
                    a = record.pop();
                    b = record.pop();
                    record.push(a * b);
                }else if(s.equals("/")){
                    b = record.pop();
                    a = record.pop();
                    record.push(a / b);
                }else{
                    record.push(Integer.parseInt(s));
                }
            }
            return record.pop();
        }
    }
}
