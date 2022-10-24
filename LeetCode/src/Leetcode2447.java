class Solution {
    public int subarrayGCD(int[] nums, int k) {
        if(nums.length == 0) return 0;
        int result = 0;
        int n = nums.length;
        for(int i = 0; i < n; i ++) {
            if(nums[i] % k != 0) continue;
            int j = i;
            int t = 0;
            while(j < n) {
                t = gcd(nums[j], t);
                if(t % k == 0) {
                    if(t == k) result ++;
                    j ++;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}