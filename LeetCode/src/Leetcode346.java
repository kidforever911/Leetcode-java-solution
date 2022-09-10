class MovingAverage {
    private double sum = 0.0;
    private int[] q;
    private int idx = 0, count = 0;


    public MovingAverage(int size) {
        q = new int[size];
    }

    public double next(int val) {
        if(count < q.length) count ++;
        sum -= q[idx];
        q[idx] = val;
        sum += q[idx];
        idx = (idx + 1) % q.length;
        return sum / count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */