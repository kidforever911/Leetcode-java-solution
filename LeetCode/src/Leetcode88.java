public class Leetcode88 {
    class Solution {
        //从前往后
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int total = nums1.length;
            int[] mergeArr = new int[total];
            int m1 = 0;
            int n1 = 0;
            for(int i = 0; i < total; i++){
                if(m1 >= m){
                    mergeArr[i] = nums2[n1];
                    n1++;
                }else if(n1 >= n){
                    mergeArr[i] = nums1[m1];
                    m1++;
                }else if(nums1[m1] <= nums2[n1]){

                    mergeArr[i] = nums1[m1];
                    m1++;
                }else{
                    mergeArr[i] = nums2[n1];
                    n1++;
                }
            }
            for(int i = 0; i < total; i++){
                nums1[i] = mergeArr[i];
            }
        }
    }

    //从后往前
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int tail1 = m - 1; int tail2 = n - 1; int total = m + n - 1;
            while(tail1 >= 0 && tail2 >= 0){
                if(nums1[tail1] > nums2[tail2]){
                    nums1[total--] = nums1[tail1--];
                }else{
                    nums1[total--] = nums2[tail2--];
                }
            }
            while(tail2 >= 0){
                nums1[total--] = nums2[tail2--];
            }
        }
    }
}
