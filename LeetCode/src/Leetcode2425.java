class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int x = 0;
        if((nums1.length & 1) != 0) for(int temp : nums2) x ^= temp;
        if((nums2.length & 1) != 0) for(int temp : nums1) x ^= temp;
        return x;
    }
}