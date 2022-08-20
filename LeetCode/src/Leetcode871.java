class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int[][] arr = new int[stations.length + 1][2];
        for(int i = 0; i < stations.length; i ++) {
            arr[i] = stations[i];
        }
        arr[stations.length] = new int[]{target, 0};
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for(int[] temp : arr) {
            while(pq.size() > 0 && startFuel < temp[0]) {
                startFuel += pq.poll();
                result ++;
            }
            if(startFuel < temp[0]) return -1;
            pq.add(temp[1]);
        }
        return result;

    }
}