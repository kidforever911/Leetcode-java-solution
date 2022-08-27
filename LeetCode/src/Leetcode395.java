class Solution {
    public int longestSubstring(String s, int k) {
        int result = 0;
        for(int l = 1; l <= 26; l ++) {
            int left = 0;
            HashMap<Character, Integer> record = new HashMap<>();
            for(int i = 0; i < s.length(); i ++) {
                record.put(s.charAt(i), record.getOrDefault(s.charAt(i), 0) + 1);
                while(record.size() > l) {
                    record.put(s.charAt(left), record.get(s.charAt(left)) - 1);
                    if(record.get(s.charAt(left)) == 0) {
                        record.remove(s.charAt(left));
                    }
                    left ++;
                }
                if(record.size() == l) {
                    boolean valid = true;
                    for(char c : record.keySet()) {
                        if(record.get(c) < k && record.get(c) > 0) {
                            valid = false;
                            break;
                        }
                    }
                    if(valid) {
                        result = Math.max(result, i - left + 1);
                    }
                }
            }
        }
        return result;
    }
}