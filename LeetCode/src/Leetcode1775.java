class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length * 6 || nums2.length > nums1.length * 6)
            return -1;
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < nums1.length; i ++) {
            sum1 += nums1[i];
        }
        for(int i = 0; i < nums2.length; i ++) {
            sum2 += nums2[i];
        }
        if(sum1 < sum2) {
            return minOperation(nums1, nums2, sum1, sum2);
        } else if(sum1 > sum2) {
            return minOperation(nums2, nums1, sum2, sum1);
        } else{
            return 0;
        }
    }
    private int minOperation(int[] n1, int[] n2, int sum1, int sum2) {
        int diff = sum2 - sum1;
        int result = 0;
        int[] count = new int[6];
        for(int x : n1) {
            count[6 - x] ++;
        }
        for(int x : n2) {
            count[x - 1] ++;
        }
        for(int i = 5; i > 0 && diff > 0; i --) {
            int operation = Math.min(count[i], (diff / i + (diff % i == 0 ? 0 : 1)));
            diff -= operation * i;
            result += operation;
        }
        return result;
    }
}