import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        while(n -- > 0){
            for(int i = result.size() - 1; i >= 0; i --){
                result.set(i, result.get(i) * 2);
                result.add(result.get(i) + 1);
            }
        }
        return result;
    }
}