import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> cellsInRange(String s) {
        List<String> result = new ArrayList<>();
        String[] str = s.split(":");
        String first = str[0];
        String second = str[1];
        for(char i = first.charAt(0); i <= second.charAt(0); i ++){
            for(char j = first.charAt(1); j <= second.charAt(1); j ++){
                result.add(new String(new char[]{i, j}));
            }
        }
        return result;
    }
}