class Solution {
    public int[] singleNumber(int[] nums) {
        int ab = 0;
        for(int x : nums) ab ^= x;
        int k = 0;
        while((ab >> k & 1) == 0) k ++;
        int[] result = new int[2];
        result[0] = get(nums, k, 0);
        result[1] = get(nums, k, 1);
        return result;
    }

    private int get(int[] nums, int k, int t) {
        int result = 0;
        for(int x : nums) {
            if((x >> k & 1) == t)
                result ^= x;
        }
        return result;
    }
}