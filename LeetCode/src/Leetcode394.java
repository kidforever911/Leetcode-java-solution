//时间复杂度o（k^n）
class Solution {
    int u = 0;
    public String decodeString(String s) {
        if(s.length() == 0) return "";
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

class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> record = new Stack<>();

        String cur = "";
        int count = 0;
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else if(c == '[') {
                nums.add(count);
                record.add(cur);
                cur = "";
                count = 0;
            } else if(c == ']') {
                String temp = cur;
                cur = record.pop();
                int number = nums.pop();
                while(number -- > 0) {
                    cur += temp;
                }
            } else {
                cur += c;
            }
        }
        return cur;
    }
}