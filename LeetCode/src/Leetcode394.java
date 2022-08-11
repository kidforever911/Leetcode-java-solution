class Solution {
    int u = 0;
    public String decodeString(String s) {
        if(s.length() == 0) return "";
        int u = 0;
        return dfs(s);
    }
    private String dfs(String s) {
        String result = "";
        while(u < s.length() && s.charAt(u) != ']') {
            if(s.charAt(u) >= 'a' && s.charAt(u) <= 'z' || s.charAt(u) >= 'A' && s.charAt(u) <= 'Z') result += s.charAt(u ++);
            else {
                if(s.charAt(u) >= '1' && s.charAt(u) <= '9') {
                    int k = u;
                    while(k < s.length() && s.charAt(k) != '[') k ++;
                    int count = Integer.parseInt(s.substring(u, k));
                    u = k + 1;
                    String str = dfs(s);
                    u ++;
                    while(count -- > 0) result += str;
                }
            }
        }
        return result;
    }
}