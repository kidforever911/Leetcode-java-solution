class Solution {
    public boolean reorderedPowerOf2(int n) {
        for(int i = 1; i < 1e9; i *= 2) {
            if(check(i, n)) {
                return true;
            }
        }
        return false;
    }
    private boolean check(int a, int b) {
        String sa = Integer.toString(a);
        String sb = Integer.toString(b);
        int[] recorda = new int[10];
        int[] recordb = new int[10];
        for(char c : sa.toCharArray()) {
            recorda[c - '0'] ++;
        }
        for(char c : sb.toCharArray()) {
            recordb[c - '0'] ++;
        }
        return Arrays.equals(recorda, recordb);
    }
}