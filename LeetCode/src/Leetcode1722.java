class Solution {
    private int[] p;
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        p = new int[n];
        for(int i = 0; i < n; i ++) p[i] = i;
        for(int[] temp : allowedSwaps) {
            p[find(temp[0])] = find(temp[1]);
        }
        HashMap<Integer, HashMap<Integer, Integer>> record = new HashMap<>();
        for(int i = 0; i < n; i ++) {
            if(!record.containsKey(find(i))) {
                record.put(find(i), new HashMap<Integer, Integer>());
            }
            HashMap<Integer, Integer> hash = record.get(find(i));
            hash.put(source[i], hash.getOrDefault(source[i], 0) + 1);
        }
        int result = 0;
        for(int i = 0; i < target.length; i ++) {
            HashMap<Integer, Integer> hash = record.get(find(i));
            if(hash.getOrDefault(target[i], 0) > 0){
                hash.put(target[i], hash.get(target[i]) - 1);
            }
            else result ++;
        }
        return result;
    }

    private int find(int x) {
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}