class Solution {
    public int[] constructRectangle(int area) {
        int mid = (int)Math.sqrt(area);
        int[] result = new int[2];
        for(int i = mid; i >= 1; i --) {
            if(area % i == 0) {
                result[0] = Math.max(area / i, i);
                result[1] = Math.min(area / i, i);
                break;
            }
        }
        return result;
    }
}