class Solution {
    public boolean isPossible(int[] target) {
        if(target.length == 1) return target[0] == 1;
        PriorityQueue<Integer> record = new PriorityQueue<>((a, b) -> (b - a));
        int total = 0;
        for(int i = 0; i < target.length; i ++) {
            record.add(target[i]);
            total += target[i];
        }
        while(record.peek() != 1) {
            int largest = record.peek();
            record.poll();
            if((total - largest) == 1) return true;
            int x = largest % (total - largest);
            total = total - largest + x;
            if(x == 0 || x == largest) return false;
            record.add(x);
        }
        return true;
    }
}