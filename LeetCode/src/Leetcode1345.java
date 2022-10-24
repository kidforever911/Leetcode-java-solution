class Solution {
    public int minJumps(int[] arr) {
        if(arr.length == 0) return 0;
        HashMap<Integer, List<Integer>> record = new HashMap<>();
        int n = arr.length;
        for(int i = 0; i < n; i ++) {
            if(!record.containsKey(arr[i])) {
                record.put(arr[i], new ArrayList<>());
            }
            record.get(arr[i]).add(i);
        }
        int INF = (int)(1e9);
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        dist[0] = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i = cur - 1; i <= cur + 1; i ++) {
                if(i >= 0 && i < n && dist[i] > dist[cur] + 1) {
                    dist[i] = dist[cur] + 1;
                    q.add(i);
                }
            }
            int val = arr[cur];
            if(record.containsKey(val)) {
                for(int i : record.get(val)) {
                    if(dist[i] > dist[cur] + 1) {
                        dist[i] = dist[cur] + 1;
                        q.add(i);
                    }
                }
                record.remove(val);
            }
        }
        return dist[n - 1];
    }
}