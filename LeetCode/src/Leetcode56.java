import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(t -> t[0]));
        List<int[]> record = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for(int i = 1; i < intervals.length; i ++){
            if(intervals[i][0] > right){
                record.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }else{
                right = Math.max(intervals[i][1], right);
            }
        }
        record.add(new int[]{left, right});
        int[][] result = new int[record.size()][2];
        for(int i = 0; i < record.size(); i ++){
            result[i] = record.get(i);
        }
        return result;
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> record = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for(int i = 1; i < intervals.length; i ++) {
            if(intervals[i][0] > right) {
                record.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }else{
                right = Math.max(intervals[i][1], right);
            }
        }
        record.add(new int[]{left, right});
        int[][] result = new int[record.size()][2];
        for(int i = 0; i < record.size(); i ++){
            result[i] = record.get(i);
        }
        return result;
    }
}