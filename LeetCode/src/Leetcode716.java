class MaxStack {
    private Stack<Integer> stack;
    //记录每次push之后当前stack的最大值
    private Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        int max = stack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
        if(x >= max) {
            max = x;
        }
        stack.push(x);
        maxStack.push(max);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        Stack<Integer> temp = new Stack<>();
        int max = maxStack.peek();
        while(stack.peek() != max) {
            temp.add(stack.pop());
            maxStack.pop();
        }
        stack.pop();
        maxStack.pop();
        while(!temp.isEmpty()) {
            push(temp.pop());
        }
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */