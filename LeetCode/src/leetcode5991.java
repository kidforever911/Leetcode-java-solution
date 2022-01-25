class Solution {
    public int[] rearrangeArray(int[] nums) {
        if(nums.length == 0) return nums;
        int n = nums.length;
        int[] result = new int[n];
        //存放正整数
        int[] a = new int[n / 2];
        //存放负整数
        int[] b = new int[n / 2];
        int indexA = 0;
        int indexB = 0;
        for(int i : nums){
            if(i <= 0){
                b[indexB ++] = i;
            }else{
                a[indexA ++] = i;
            }
        }
        int index = 0;
        for(int i = 0; i < a.length; i ++){
            result[index ++] = a[i];
            result[index ++] = b[i];
        }
        return result;
    }
}