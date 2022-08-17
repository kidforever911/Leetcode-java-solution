class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0 || intervals[0].length == 0) return 0;
        int result = 0;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        int index = 0;
        for(int[] temp : intervals) {
            start[index] = temp[0];
            end[index] = temp[1];
            index ++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int endPoint = 0;
        for(int i = 0; i < intervals.length; i ++) {
            result ++;
            if(start[i] >= end[endPoint]) {
                result --;
                endPoint ++;
            }
        }
        return result;
    }
}