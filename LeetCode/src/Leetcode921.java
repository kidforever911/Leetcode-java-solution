class Solution {
    public int minAddToMakeValid(String s) {
        int left = 0, right = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                right ++;
            } else if(right > 0) {
                right --;
            } else{
                left ++;
            }
        }
        return left + right;
    }
}