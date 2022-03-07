import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> result = new ArrayList<>();
        if(security.length == 0 || security.length < time) return result;
        int n = security.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0; i < n; i ++){
            if(i > 0 && security[i] <= security[i - 1]){
                left[i] = left[i - 1] + 1;
            }
        }
        for(int i = n - 1; i >= 0; i --){
            if(i < n - 1 && security[i] <= security[i + 1]){
                right[i] = right[i + 1] + 1;
            }
        }
        for(int i = time; i < n - time; i ++){
            if(left[i] >= time && right[i] >= time){
                result.add(i);
            }
        }
        return result;
    }
}