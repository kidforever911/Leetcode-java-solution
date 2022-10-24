class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int start1 = convert(event1[0]);
        int start2 = convert(event2[0]);
        int end1 = convert(event1[1]);
        int end2 = convert(event2[1]);
        return Math.max(start1, start2) <= Math.min(end1, end2);
    }
    private int convert(String s) {
        return ((s.charAt(0) - '0') * 10 + (s.charAt(1) - '0')) * 60 +
                ((s.charAt(3) - '0') * 10 + s.charAt(4) - '0');
    }
}