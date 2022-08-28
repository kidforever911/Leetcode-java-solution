class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> record = new Stack<>();
        record.add(0);
        for(char c : s.toCharArray()) {
            if(c == '(') {
                record.add(0);
            } else {
                int t = record.pop();
                if(t == 0) t += 1;
                else t *= 2;
                record.add(record.pop() + t);
            }
        }
        return record.peek();
    }
}