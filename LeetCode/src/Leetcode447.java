import java.util.HashMap;

public class Leetcode447 {
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int result = 0;
            if(points.length == 0) return result;
            HashMap<Integer, Integer> record = new HashMap<>();
            for(int i = 0; i < points.length; i++){
                for(int j = 0; j < points.length; j++){
                    if(i == j){
                        continue;
                    }
                    int dist = getDistance(points[i], points[j]);
                    record.put(dist, record.getOrDefault(dist, 0) + 1);
                }
                for(int val : record.values()){
                    result += val * (val - 1);
                }
                record.clear();
            }
            return result;
        }

        private int getDistance(int[] a, int[] b){
            int dx = a[0] - b[0];
            int dy = a[1] - b[1];
            return dx*dx + dy*dy;
        }
    }
}
