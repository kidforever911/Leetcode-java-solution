class Solution {
    public int calculate(String s) {
        boolean isMinus = true;
        Stack<Integer> nums = new Stack<>();
        Stack<Character> op = new Stack<>();
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(c == ' ') continue;
            if(c == '(' || c == '+') op.push(c);
            else if(c == '-'){
                if(isMinus) nums.push(0);
                op.push(c);
            }
            else if(c == ')'){
                op.pop();
                if(!op.isEmpty() && op.peek() != '(') eval(nums, op);
            }else{
                int x = 0, j = i;
                while(j < s.length() && Character.isDigit(s.charAt(j))){
                    x = x * 10 + (s.charAt(j ++) - '0');
                }
                i = j - 1;
                nums.push(x);
                while(op.size() > 0 && op.peek() != '(') eval(nums, op);
            }
            if(c =='(') isMinus = true;
            else isMinus = false;
        }
        while(op.size() > 0) eval(nums, op);
        return nums.peek();
    }

    private void eval(Stack<Integer> nums, Stack<Character> op){
        int b = nums.peek(); nums.pop();
        int a = nums.peek(); nums.pop();
        int c = op.peek(); op.pop();
        int r = 0;
        if(c == '+') nums.push(a + b);
        else nums.push(a - b);
    }

}

class Solution {
    public int calculate(String s) {
        if(s.length() == 0) return 0;
        Stack<Character> op = new Stack<>();
        Stack<Integer> num = new Stack<>();
        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(c == ' ') continue;
            if(Character.isDigit(c)) {
                int k = i;
                int x = 0;
                while(k < s.length() && Character.isDigit(s.charAt(k))) x = x * 10 + (s.charAt(k ++) - '0');
                i = k - 1;
                num.add(x);
            } else if(c == '(') op.add(s.charAt(i));
            else if(c == ')') {
                while(op.peek() != '(') eval(num, op);
                op.pop();
            } else {
                if(i == 0 || s.charAt(i - 1) == '(') {
                    num.push(0);
                }
                while(!op.isEmpty() && op.peek() != '(') eval(num, op);
                op.push(c);
            }
        }
        while(!op.isEmpty()) eval(num, op);
        return num.peek();
    }

    private void eval(Stack<Integer> num, Stack<Character> op) {
        int a = num.pop();
        int b = num.pop();
        char c = op.pop();
        int r = 0;
        if(c == '+') r = a + b;
        else r = b - a;
        num.add(r);
    }
}