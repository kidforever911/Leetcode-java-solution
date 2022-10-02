class Solution {
    private int[] p;
    public int countComponents(int n, int[][] edges) {
        p = new int[n];
        int result = 0;
        HashSet<Integer> record = new HashSet<>();
        for(int i = 0; i < n; i ++) p[i] = i;
        for(int[] temp : edges) {
            int a = find(temp[0]);
            int b = find(temp[1]);
            if(a != b) p[a] = b;
        }
        for(int i = 0; i < n; i ++) {
            int x = find(i);
            if(!record.contains(x)) {
                result ++;
            }
            record.add(x);
        }
        return result;
    }

    private int find(int x) {
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}