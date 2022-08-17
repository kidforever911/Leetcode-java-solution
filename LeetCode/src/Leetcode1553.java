class Solution {
    public int minDays(int n) {
        HashMap<Integer, Integer> record = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        record.put(n, 0);
        while(q.size() > 0) {
            int cur = q.poll();
            int dist = record.get(cur);
            if(cur == 0) {
                return dist;
            }
            if(!record.containsKey(cur - 1)) {
                record.put(cur - 1, dist + 1);
                q.add(cur - 1);
            }
            if(cur % 2 == 0 && !record.containsKey(cur / 2)) {
                record.put(cur / 2, dist + 1);
                q.add(cur / 2);
            }
            if(cur % 3 == 0 && !record.containsKey(cur / 3)) {
                record.put(cur / 3, dist + 1);
                q.add(cur / 3);
            }
        }
        return -1;
    }
}