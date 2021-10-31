import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        if(s.length() == 0) return 0;
        HashMap<Character, Integer> record = new HashMap<>();
        record.put('M', 1000);
        record.put('D', 500);
        record.put('C', 100);
        record.put('L', 50);
        record.put('X', 10);
        record.put('V', 5);
        record.put('I', 1);
        char[] letters = s.toCharArray();
        int result = 0;
        for(int i = 0; i < s.length(); i ++){
            if(i + 1 < s.length() && record.get(letters[i + 1]) > record.get(letters[i])){
                result -= record.get(letters[i]);
            }else{
                result += record.get(letters[i]);
            }
        }
        return result;
    }

}
