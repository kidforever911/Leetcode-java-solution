class CustomStack {
    private int[] record;
    private int top;

    public CustomStack(int maxSize) {
        record = new int[maxSize];
        top = 0;
    }

    public void push(int x) {
        if(top == record.length) return;
        record[top ++] = x;
    }

    public int pop() {
        if(top == 0) return -1;
        return record[-- top];
    }

    public void increment(int k, int val) {
        for(int i = 0; i < k && i < top; i ++) {
            record[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */