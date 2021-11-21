import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() == 0) return result;
        HashMap<String, Integer> record = new HashMap<>();
        for(int i = 0; i + 10 <= s.length(); i ++){
            String temp = s.substring(i, i + 10);
            record.put(temp, record.getOrDefault(temp, 0) + 1);
        }
        for(String temp : record.keySet()){
            if(record.get(temp) > 1){
                result.add(temp);
            }
        }
        return result;
    }
}