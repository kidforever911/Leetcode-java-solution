class MedianFinder {
    PriorityQueue<Integer> up = new PriorityQueue<>((a, b) -> (a - b));
    PriorityQueue<Integer> down = new PriorityQueue<>((a, b) -> (b - a));
    int count = 0;
    public MedianFinder() {

    }

    public void addNum(int num) {
        count ++;
        if(down.isEmpty() || num <= down.peek()) {
            down.add(num);
            if(down.size() > up.size() + 1) {
                up.add(down.poll());
            }
        } else {
            up.add(num);
            if(up.size() > down.size()) {
                down.add(up.poll());
            }
        }
    }

    public double findMedian() {
        return count % 2 == 0 ? (up.peek() + down.peek()) / 2.0 : down.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */