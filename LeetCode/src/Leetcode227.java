class Solution {
    private Stack<Integer> nums;
    private Stack<Character> op;

    public int calculate(String s) {
        nums = new Stack<>();
        op = new Stack<>();
        if(s.length() == 0) return 0;
        HashMap<Character, Integer> record = new HashMap<>();
        record.put('+', 1);
        record.put('-', 1);
        record.put('*', 2);
        record.put('/', 2);
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(c == ' ') continue;
            else if(Character.isDigit(c)){
                int j = i, x = 0;
                while(j < s.length() && Character.isDigit(s.charAt(j))) x = x * 10 + (s.charAt(j ++) - '0');
                nums.push(x);
                i = j - 1;
            }else {
                while(op.size() > 0 && record.get(op.peek()) >= record.get(c)){
                    eval();
                }
                op.push(c);
            }
        }
        while(op.size() > 0) eval();
        return nums.peek();
    }

    private void eval(){
        int b = nums.pop();
        int a = nums.pop();
        char c = op.pop();
        int r;
        if(c == '+') r = a + b;
        else if(c == '-') r = a - b;
        else if(c == '*') r = a * b;
        else r = a / b;
        nums.push(r);
    }
}