class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[k];
        for(int i = Math.max(0, k - m); i <= Math.min(n, k); i ++) {
            int[] a = select(nums1, i);
            int[] b = select(nums2, k - i);
            int[] c = merge(a, b);
            if(isBigger(c, 0, result, 0)) {
                result = c;
            }
        }
        return result;
    }

    private int[] select(int[] nums, int k) {
        int[] result = new int[k];
        for(int i = 0, j = 0; i < nums.length; i ++) {
            while(j > 0 && result[j - 1] < nums[i] && nums.length - i >= k - j + 1) {
                j --;
            }
            if(j < k) result[j ++] = nums[i];
        }
        return result;
    }

    private int[] merge(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int[] result = new int[m + n];
        int i = 0, j = 0, k = 0;
        while(i < m && j < n) {
            if(isBigger(a, i, b, j)) result[k ++] = a[i ++];
            else result[k ++] = b[j ++];
        }
        while(i < m) result[k ++] = a[i ++];
        while(j < n) result[k ++] = b[j ++];
        return result;
    }

    private boolean isBigger(int[] a, int i, int[] b, int j) {
        int m = a.length, n = b.length;
        while(i < m && j < n && a[i] == b[j]) {
            i ++;
            j ++;
        }
        if(j == n || i < m && a[i] > b[j]) return true;
        return false;
    }
}