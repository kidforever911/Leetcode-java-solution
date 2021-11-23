
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int k = (n1 + n2 + 1) / 2;
        int l = 0;
        int r = n1;

        while (l < r) {
            int m1 = l + (r - l) / 2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1])
                l = m1 + 1;
            else
                r = m1;
        }

        int m1 = l;
        int m2 = k - l;

        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);

        if ((n1 + n2) % 2 == 1)
            return c1;

        int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1],
                m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);

        return (c1 + c2) * 0.5;
    }
}


//time complexity o(log(m*n))
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int total = n1 + n2;
        double result = 0.0;
        if(total % 2 == 0){
            double left = find(nums1, 0, nums2, 0, total / 2);
            double right = find(nums1, 0, nums2, 0, total / 2 + 1);
            result = (left + right) / 2.0;
        }else{
            result = find(nums1, 0, nums2, 0, total / 2 + 1);
        }
        return result;
    }

    //从indexN1到nums1最后一个元素和从indexN2到nums2最后一个元素迭代找第k个位置
    private double find(int[] nums1, int indexN1, int[] nums2, int indexN2, int k){
        if(nums1.length - indexN1 > nums2.length - indexN2) return find(nums2, indexN2, nums1, indexN1, k);
        // 如果只找nums1和nums2中的第一个数则返回最小值
        if(k == 1){
            //如果nums1没有数了且找第一个数，返回nums2第一个数
            if(nums1.length == indexN1) return nums2[indexN2];
            else return Math.min(nums1[indexN1], nums2[indexN2]);
        }
        //如果nums1没有数了，返回nums2第k个数
        if(nums1.length == indexN1) return nums2[indexN2 + k - 1];
        //否则，迭代的比较k/2位置上数的大小
        int s1 = Math.min(nums1.length, indexN1 + k / 2), s2 = indexN2 + k - k / 2;
        if(nums1[s1 - 1] > nums2[s2 - 1])
            return find(nums1, indexN1, nums2, s2, k - (s2 - indexN2));
        else
            return find(nums1, s1, nums2, indexN2, k - (s1 - indexN1));
    }
}
