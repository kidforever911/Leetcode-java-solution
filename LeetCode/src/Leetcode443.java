class Solution {
    public int compress(char[] chars) {
        if(chars.length == 0) return 0;
        int idx = 0;
        int slow = 0;
        int fast = 0;
        while(slow < chars.length && fast < chars.length && idx < chars.length) {
            int count = 0;
            while(fast < chars.length && chars[fast] == chars[slow]) {
                count ++;
                fast ++;
            }
            chars[idx ++] = chars[slow];
            if(count > 1 && idx < chars.length) {
                String s = String.valueOf(count);
                for(int i = 0; i < s.length(); i ++) {
                    chars[idx ++] = s.charAt(i);
                }
            }
            slow = fast;
        }
        return idx;
    }
}