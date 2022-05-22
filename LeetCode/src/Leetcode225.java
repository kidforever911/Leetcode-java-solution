class MyStack {

    private Queue<Integer> q;
    private Queue<Integer> qTemp;

    public MyStack() {
        q = new LinkedList<>();
        qTemp = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
    }

    public int pop() {
        while(q.size() > 1){
            qTemp.add(q.poll());
        }
        int t = q.poll();
        while(!qTemp.isEmpty()){
            q.add(qTemp.poll());
        }
        return t;
    }

    public int top() {
        while(q.size() > 1){
            qTemp.add(q.poll());
        }
        int t = q.poll();
        while(!qTemp.isEmpty()){
            q.add(qTemp.poll());
        }
        q.add(t);
        return t;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */