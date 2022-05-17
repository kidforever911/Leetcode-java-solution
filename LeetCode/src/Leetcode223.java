class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int a = Math.max(0, Math.min(bx2, ax2) - Math.max(ax1, bx1));
        int b = Math.max(0, Math.min(by2, ay2) - Math.max(ay1, by1));
        return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - a * b;

    }
}