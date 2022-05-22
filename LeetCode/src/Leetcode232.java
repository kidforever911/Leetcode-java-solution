class MyQueue {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> cache = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        stack.push(x);
    }

    void copy(Stack<Integer> a, Stack<Integer> b){
        while(!a.isEmpty()){
            b.push(a.peek());
            a.pop();
        }
    }

    public int pop() {
        copy(stack, cache);
        int result = cache.peek();
        cache.pop();
        copy(cache, stack);
        return result;
    }

    public int peek() {
        copy(stack, cache);
        int result = cache.peek();
        copy(cache, stack);
        return result;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

class MyQueue {
    private Stack<Integer> s;
    private Stack<Integer> sTemp;

    public MyQueue() {
        s = new Stack<>();
        sTemp = new Stack<>();
    }

    public void push(int x) {
        s.push(x);

    }

    public int pop() {
        while(s.size() > 1) sTemp.add(s.pop());
        int t = s.pop();
        while(!sTemp.isEmpty()) s.add(sTemp.pop());
        return t;
    }

    public int peek() {
        while(s.size() > 1) sTemp.add(s.pop());
        int t = s.peek();
        while(!sTemp.isEmpty()) s.add(sTemp.pop());
        return t;
    }

    public boolean empty() {
        return s.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */