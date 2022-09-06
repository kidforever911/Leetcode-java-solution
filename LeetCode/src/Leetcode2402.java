class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        PriorityQueue<Pair> rooms = new PriorityQueue<>((a, b) -> {
            if (a.endTime < b.endTime) return -1;
            else if (a.endTime == b.endTime) return a.id - b.id;
            else return 1;
        });
        int result = 0;
        int[] count = new int[n];
        Arrays.sort(meetings, (a, b) -> (a[0] - b[0]));
        for(int i = 0; i < n; i ++) heap.add(i);
        for(int[] temp : meetings) {
            while(rooms.size() != 0 && rooms.peek().endTime <= temp[0]) {
                heap.add(rooms.peek().id);
                rooms.poll();
            }
            if(heap.size() > 0) {
                int freeRoom = heap.poll();
                rooms.add(new Pair(temp[1], freeRoom));
                count[freeRoom] ++;
            } else {
                Pair busyRoom = rooms.poll();
                Pair arr = new Pair(busyRoom.endTime + temp[1] - temp[0], busyRoom.id);
                count[busyRoom.id] ++;
                rooms.add(arr);
            }
        }
        for(int i = 1; i < count.length; i ++) {
            if(count[result] < count[i]) {
                result = i;
            }
        }
        return result;
    }

    class Pair{
        long endTime;
        int id;
        public Pair(long endTime, int id) {
            this.endTime = endTime;
            this.id = id;
        }
    }
}