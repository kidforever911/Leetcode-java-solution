class Solution {
    public int bestRotation(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int[] b = new int[n + 1];
        for(int i = 0; i < n; i ++){
            int left = i - nums[i] + 1, right = i;
            if(left >= 0){
                b[left] ++;
                b[right + 1] --;
            }else{
                b[0] ++;
                b[right + 1] --;
                b[left + n] ++;
                b[n] --;
            }
        }
        int result = Integer.MAX_VALUE, index = 0;
        for(int i = 0, sum = 0; i < n; i ++){
            sum += b[i];
            if(result > sum){
                result = sum;
                index = i;
            }
        }
        return index;
    }
}