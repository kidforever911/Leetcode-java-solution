class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Character> st = new HashMap<>();
        HashMap<Character, Character> ts = new HashMap<>();
        for(int i = 0; i < s.length(); i ++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(st.containsKey(a) && st.get(a) != b) return false;
            st.put(a, b);
            if(ts.containsKey(b) && ts.get(b) != a) return false;
            ts.put(b, a);
        }
        return true;
    }
}