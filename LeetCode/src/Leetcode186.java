class Solution {
    public void reverseWords(char[] s) {
        int left = 0, right = s.length - 1;
        while(left < right) {
            reverse(s, left, right);
            left ++;
            right --;
        }
        for(int slow = 0, fast = 0; fast < s.length; fast ++) {
            if(s[fast] == ' ' || fast == s.length - 1) {
                int i = slow, j = fast == s.length - 1 ? fast : fast - 1;
                while(i < j) {
                    reverse(s, i, j);
                    i ++;
                    j --;
                }
                slow = fast + 1;
            }
        }
        return;
    }

    private void reverse(char[] s, int x, int y) {
        char temp = s[x];
        s[x] = s[y];
        s[y] = temp;
    }
}