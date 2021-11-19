import java.util.HashMap;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        if(m == 0 || n == 0) return 0;
        int result = 0;
        for(int i = 0; i < n; i ++){
            HashMap<String, Integer> record = new HashMap<>();
            int ss = 0, vs = 0;
            for(int j = 0; j < n; j ++){
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1]) ss ++;
                else if(points[i][0] == points[j][0]) vs ++;
                else{
                    int y = points[i][1] - points[j][1];
                    int x = points[i][0] - points[j][0];
                    int c = gcd(x, y);
                    x /= c;
                    y /= c;
                    String t = x + "/" + y;
                    record.put(t, record.getOrDefault(t, 0) + 1);
                }
            }
            int temp = vs;
            for(int val : record.values()){
                temp = Math.max(temp, val);
            }
            result = Math.max(result, temp + ss);
        }
        return result;
    }

    private int gcd(int x, int y){
        return y == 0 ? x : gcd(y, x % y);
    }
}