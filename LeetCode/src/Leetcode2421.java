class Solution {
    private int[] p;
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int result = 0;
        int n = vals.length;
        Integer[] index = new Integer[n];
        p = new int[n];
        List<Integer>[] record = new List[n];
        for(int i = 0; i < n; i ++) {
            record[i] = new ArrayList<>();
            p[i] = index[i] = i;
        }
        Arrays.sort(index, (a, b) -> (vals[a] - vals[b]));
        for(int[] x : edges) {
            record[x[0]].add(x[1]);
            record[x[1]].add(x[0]);
        }
        for(int i = 0; i < n; i ++) {
            int j = i + 1;
            while(j < n && vals[index[i]] == vals[index[j]]) j ++;
            for(int k = i; k < j; k ++) {
                int x = index[k];
                for(int y : record[x]) {
                    if(vals[x] >= vals[y]) p[find(x)] = find(y);
                }
            }
            HashMap<Integer, Integer> count = new HashMap<>();
            for(int k = i; k < j; k ++) {
                count.put(find(index[k]), count.getOrDefault(find(index[k]), 0) + 1);
            }
            for(int temp : count.values()) {
                result += (temp* (temp + 1)) / 2;
            }
            i = j - 1;
        }

        return result;
    }

    private int find(int x) {
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}