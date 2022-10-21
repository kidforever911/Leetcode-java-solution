class Solution {
    public int splitArray(int[] nums, int m) {
        long left = 0;
        long right = Integer.MAX_VALUE;
        while(left < right) {
            long mid = left + right >> 1;
            if(check(nums, mid, m)) right = mid;
            else left = mid + 1;
        }
        return (int) right;
    }

    private boolean check(int[] nums, long mid, int m) {
        int sum = 0, count = 0;
        for(int x : nums) {
            if(x > mid) return false;
            if(sum + x > mid) {
                count ++;
                sum = x;
            } else {
                sum += x;
            }
        }
        if(sum > 0) count ++;
        return count <= m;
    }
}