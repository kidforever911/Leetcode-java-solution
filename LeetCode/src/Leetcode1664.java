class Solution {
    public int waysToMakeFair(int[] nums) {
        if(nums.length == 0) return 0;
        int result = 0;
        int n = nums.length;
        int[] oddArray = new int[n + 1];
        int[] evenArray = new int[n + 1];
        for(int i = 1; i <= n; i ++) {
            oddArray[i] = oddArray[i - 1];
            evenArray[i] = evenArray[i - 1];
            if(i % 2 == 0) evenArray[i] += nums[i - 1];
            else oddArray[i] += nums[i - 1];
        }
        for(int i = 1; i <= n; i ++) {
            int odd = oddArray[i - 1] + evenArray[n] - evenArray[i];
            int even = evenArray[i - 1] + oddArray[n] - oddArray[i];
            if(odd == even) result ++;
        }
        return result;
    }
}