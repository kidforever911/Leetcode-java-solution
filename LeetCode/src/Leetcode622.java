class MyCircularQueue {
    private int hh = 0, tt = 0;
    private int[] record;

    public MyCircularQueue(int k) {
        record = new int[k + 1];
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        record[tt ++] = value;
        if(tt == record.length) tt = 0;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        hh ++;
        if(hh == record.length) hh = 0;
        return true;
    }

    public int Front() {
        if(isEmpty()) return -1;
        return record[hh];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        int t = tt - 1;
        if(t < 0) t+= record.length;
        return record[t];
    }

    public boolean isEmpty() {
        return hh == tt;
    }

    public boolean isFull() {
        return (tt + 1) % record.length == hh;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */