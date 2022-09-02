class Solution {
    private int N = 100010, idx = 0;
    private int[] h = new int[N];
    private int[] ne = new int[2 * N];
    private int[] e = new int[2 * N];
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Arrays.fill(h, -1);
        for(int i = 0; i < ppid.size(); i ++) {
            if(ppid.get(i) != 0) {
                add(ppid.get(i), pid.get(i));
            }
        }
        List<Integer> result = new ArrayList<>();
        Queue<Integer> record = new LinkedList<>();
        record.add(kill);
        result.add(kill);
        while(record.size() > 0) {
            int cur = record.poll();
            for(int i = h[cur]; i != -1; i = ne[i]) {
                int j = e[i];
                record.add(j);
                result.add(j);
            }
        }
        return result;
    }

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }
}