class Solution {
    public int countMaxOrSubsets(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length, solution = 1 << n;
        int max = 0;
        int result = 0;
        for(int i = 0; i < solution; i ++){
            int cur = 0;
            for(int j = 0; j < n; j ++){
                if(((i >> j) & 1) == 1) cur = cur | nums[j];

            }
            if(cur > max){
                max = cur;
                result = 1;
            }else if(cur == max){
                result ++;
            }
        }
        return result;
    }
}