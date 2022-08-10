class Solution {
    public int maxDepth(String s) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                count ++;
            }else if(c == ')') {
                count --;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}