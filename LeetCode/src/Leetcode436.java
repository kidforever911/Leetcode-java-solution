class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        HashMap<Integer, Integer> record = new HashMap<>();
        for(int i = 0; i < n; i ++) {
            record.put(intervals[i][0], i);
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        for(int i = 0; i < n; i ++) {
            int l = 0, r = n - 1;
            while(l < r) {
                int mid = l + r >> 1;
                if(intervals[mid][0] >= intervals[i][1]) r = mid;
                else l = mid + 1;
            }
            if(intervals[l][0] >= intervals[i][1]) {
                result[record.get(intervals[i][0])] = record.get(intervals[l][0]);
            }
        }
        return result;
    }
}