import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();
            if(strs.length == 0) return result;
            HashMap<String, List<String>> record = new HashMap<>();
            for(String s : strs){
                String answer = s;
                char[] ch = s.toCharArray();
                Arrays.sort(ch);
                String str = new String(ch);
                if(!record.containsKey(str)){
                    record.put(str, new ArrayList<>());
                }
                record.get(str).add(answer);
            }
            for(List<String> list : record.values()){
                result.add(list);
            }
            return result;
        }
    }
}
