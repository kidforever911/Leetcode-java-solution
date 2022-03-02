import java.util.Arrays;

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        if(time.length == 0) return 0;
        if(time.length == 1) return (long)time[0] * (long)totalTrips;
        Arrays.sort(time);
        int minValue = time[0];
        long left = 0, right = minValue * totalTrips;
        while(left < right){
            long mid = left + right >> 1;
            long temp = 0;
            for(int i = 0; i < time.length; i ++){
                temp += mid / time[i];
            }
            if(temp >= totalTrips) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}