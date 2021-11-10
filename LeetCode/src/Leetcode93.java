import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() == 0) return result;
        generateIp(s, 0, 0, "", result);
        return result;
    }

    private void generateIp(String s, int index, int number, String record, List<String> result){
        if(index == s.length()){
            if(number == 4){
                record = record.substring(0, record.length() - 1);
                result.add(record);
                return;
            }
        }
        if(number == 4) return;

        for(int i = index, t = 0; i < s.length(); i ++){
            if(i > index && s.charAt(index) == '0') break; //有前导零的情况
            t = t * 10 + (s.charAt(i) - '0');
            if(t <= 255) generateIp(s, i + 1, number + 1, record + Integer.toString(t) + '.', result);
            else break;
        }
    }
}