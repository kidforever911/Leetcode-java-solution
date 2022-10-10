class Solution {
    public String robotWithString(String s) {
        if(s.length() == 0) return s;
        StringBuilder result = new StringBuilder();
        StringBuilder t = new StringBuilder();
        int[] record = new int[26];
        Arrays.fill(record, -1);
        for(int i = 0; i < s.length(); i ++) {
            record[s.charAt(i) - 'a'] = i;
        }
        for(int i = 0, k = 0; i < 26 && k < s.length(); i ++) {
            char c = (char)(i + 'a');
            while(!t.isEmpty() && t.charAt(t.length() - 1) <= c) {
                result.append(t.charAt(t.length() - 1));
                t.deleteCharAt(t.length() - 1);
            }
            while(k <= record[i]) {
                if(c == s.charAt(k)) {
                    result.append(c);
                } else {
                    t.append(s.charAt(k));
                }
                k ++;
            }
        }
        t.reverse();
        return result.toString() + t.toString();
    }
}