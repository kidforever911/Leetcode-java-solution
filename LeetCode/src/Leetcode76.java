import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";
        String result = "";
        HashMap<Character, Integer> hs = new HashMap<>();
        HashMap<Character, Integer> ht = new HashMap<>();
        for(char c : t.toCharArray()){
            ht.put(c, ht.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for(int i = 0, j = 0; i < s.length(); i ++){
            char ci = s.charAt(i);
            hs.put(ci, hs.getOrDefault(ci, 0) + 1);
            if(ht.getOrDefault(ci, 0) >= hs.get(ci)) count ++;
            while(j < i && (ht.getOrDefault(s.charAt(j), 0) < hs.get(s.charAt(j)))){
                hs.put(s.charAt(j), hs.get(s.charAt(j)) - 1);
                j ++;
            }
            if(count == t.length()){
                if(result.length() == 0 || result.length() > i - j + 1){
                    result = s.substring(j, i + 1);
                }
            }
        }
        return result;
    }
}