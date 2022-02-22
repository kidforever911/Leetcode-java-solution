import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == 0 || k >= num.length()) return "0";
        Stack<Integer> record = new Stack<>();
        StringBuilder result = new StringBuilder();
        int n = num.length() - k;
        for(int i = 0; i < num.length(); i ++){
            int temp = num.charAt(i) - '0';
            while(!record.isEmpty() && k > 0){
                if(record.peek() > temp){
                    record.pop();
                    k --;
                }else{
                    break;
                }
            }
            record.add(temp);
        }

        for(int i : record){
            result.append((char)(i + '0'));
            n --;
            if(n <= 0){
                break;
            }
        }
        String answer = result.toString();
        int index = 0;
        while(index < answer.length() && answer.charAt(index) == '0') index ++;
        answer = answer.substring(index);
        return answer.isEmpty()? "0" : answer;
    }
}