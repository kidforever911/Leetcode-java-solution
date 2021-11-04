import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> record = new ArrayList<>();
        int k = 0;
        while(k < intervals.length && newInterval[0] > intervals[k][1]){
            record.add(new int[]{intervals[k][0], intervals[k][1]});
            k++;
        }

        if(k < intervals.length){
            newInterval[0] = Math.min(intervals[k][0], newInterval[0]);
            while(k < intervals.length && intervals[k][0] <= newInterval[1]){
                newInterval[1] = Math.max(newInterval[1], intervals[k][1]);
                k++;
            }
        }
        record.add(new int[]{newInterval[0], newInterval[1]});

        while(k < intervals.length){
            record.add(new int[]{intervals[k][0], intervals[k][1]});
            k++;
        }

        int[][] result = new int[record.size()][2];
        for(int i = 0; i < record.size(); i ++){
            result[i] = record.get(i);
        }
        return result;
    }
}