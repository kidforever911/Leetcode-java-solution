import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> stackMin;

    public MinStack() {
        stack = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(stackMin.isEmpty() || stackMin.peek() >= val) stackMin.push(val);
    }

    public void pop() {
        int t = stack.pop();
        if(t == stackMin.peek()) stackMin.pop();
        // if(stack.peek() == stackMin.peek()) stackMin.pop();
        // stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}

class MinStack {
    private Stack<Integer> record;
    private int min;

    public MinStack() {
        record = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val <= min) {
            record.push(min);
            min = val;
        }
        record.push(val);
    }

    public void pop() {
        if(record.pop() == min) min = record.pop();
    }

    public int top() {
        return record.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */