class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        if(s.length() == 0) return "";
        int[] b = new int[s.length() + 2];
        int[] a = new int[s.length() + 1];
        for(int i = 1; i <= s.length(); i ++) {
            a[i] = s.charAt(i - 1) - 'a';
            insert(i, i, a[i], b);
        }
        for(int[] temp : shifts) {
            if(temp[2] == 0) {
                insert(temp[0] + 1, temp[1] + 1, -1, b);
            } else {
                insert(temp[0] + 1, temp[1] + 1, 1, b);
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 1; i <= s.length(); i ++) {
            b[i] += b[i - 1];
            result.append((char)((b[i] % 26 + 26) % 26 + 'a'));
        }
        return result.toString();
    }
    private void insert(int left, int right, int c, int[] b) {
        b[left] += c;
        b[right + 1] -= c;
    }
}