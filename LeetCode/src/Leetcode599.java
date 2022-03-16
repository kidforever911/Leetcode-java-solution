import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> record = new HashMap<>();
        for(int i = 0; i < list1.length; i ++){
            record.put(list1[i], i);
        }
        int index = Integer.MAX_VALUE;
        for(int i = 0; i < list2.length; i ++){
            if(record.containsKey(list2[i])){
                if(index > i + record.get(list2[i])){
                    result.clear();
                    result.add(list2[i]);
                    index = i + record.get(list2[i]);
                }else if(index == i + record.get(list2[i])){
                    result.add(list2[i]);
                }
            }
        }
        String[] answer = new String[result.size()];
        for(int i = 0; i < result.size(); i ++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}