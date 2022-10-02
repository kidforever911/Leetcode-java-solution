class Solution {
    public String removeDuplicateLetters(String s) {
        if(s.length() == 0) return "";
        HashMap<Character, Boolean> recordChar = new HashMap<>();
        HashMap<Character, Integer> recordIndex = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i ++) recordIndex.put(s.charAt(i), i);
        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if(recordChar.getOrDefault(c, false)) continue;
            while(!result.isEmpty() && result.charAt(result.length() - 1) > c && recordIndex.getOrDefault(result.charAt(result.length() - 1), 0) > i) {
                recordChar.put(result.charAt(result.length() - 1), false);
                result.deleteCharAt(result.length() - 1);
            }
            result.append(s.charAt(i));
            recordChar.put(s.charAt(i), true);
        }
        return result.toString();
    }
}