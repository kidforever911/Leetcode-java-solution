import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> record = new HashMap<>();
        char[] letters = s.toCharArray();
        for(char c : letters){
            record.put(c, record.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < letters.length; i ++){
            if(record.get(letters[i]) == 1){
                return i;
            }
        }
        return -1;
    }
}

class Solution {
    public int firstUniqChar(String s) {
        if(s.length() ==0) return 0;
        int[] count = new int[26];
        char[] letters = s.toCharArray();
        for(int i = 0; i < letters.length; i ++){
            int temp = letters[i] - 'a';
            count[temp] ++;
        }
        for(int i = 0; i < letters.length; i ++){
            int temp = letters[i] - 'a';
            if(count[temp] == 1){
                return i;
            }
        }
        return -1;
    }
}