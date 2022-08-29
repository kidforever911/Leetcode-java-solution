class Solution {
    private int n;
    private int N = 100010;
    private int idx = 0;
    private int[] h = new int[N];
    private int[] ne = new int[2 * N];
    private int[] e = new int[N];
    private int[] d = new int[N + 1];
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        n = k;
        int[] row = topSort(rowConditions);
        int[] col = topSort(colConditions);
        if(row.length < n || col.length < n) return new int[0][0];
        int[][] result = new int[n][n];
        for(int i = 1; i <= n; i ++) {
            if(get(row, i) != -1 && get(col, i) != -1) {
                result[get(row, i)][get(col, i)] = i;
            } else {
                return new int[0][0];
            }
        }
        return result;
    }

    private int get(int[] arr, int x) {
        for(int i = 0; i < arr.length; i ++) {
            if(arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    private int[] topSort(int[][] graph) {
        Arrays.fill(h, -1);
        for(int[] x : graph) {
            add(x[0], x[1]);
            d[x[1]] ++;
        }
        Queue<Integer> record = new LinkedList<>();
        for(int i = 1; i <= n; i ++) {
            if(d[i] == 0) {
                record.add(i);
            }
        }
        int[] result = new int[n];
        int index = 0;
        while(record.size() > 0) {
            int cur = record.poll();
            result[index ++] = cur;
            for(int i = h[cur]; i != -1; i = ne[i]) {
                int j = e[i];
                if(-- d[j] == 0) {
                    record.add(j);
                }
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