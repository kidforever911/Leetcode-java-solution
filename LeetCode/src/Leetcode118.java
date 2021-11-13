import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> f = new ArrayList<>();
        if(numRows == 0) return f;
        f.add(Arrays.asList(1));
        for(int i = 1; i < numRows; i ++){
            List<Integer> line = new ArrayList<>();
            line.add(1);
            for(int j = 1; j < i; j ++){
                line.add(f.get(i - 1).get(j - 1) + f.get(i - 1).get(j));
            }
            line.add(1);
            f.add(line);
        }
        return f;
    }
}