class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length == 0) return 0;
        int left = 0, right = 0;
        int index = -1;
        int[] rightSum = new int[nums.length];
        int[] leftSum = new int[nums.length];
        for(int i = 1; i < nums.length; i ++){
            left += nums[i - 1];
            leftSum[i] = left;
        }
        for(int i = nums.length - 2; i >= 0; i --){
            right += nums[i + 1];
            rightSum[i] = right;
        }
        for(int i = 0; i < nums.length; i ++){
            if(leftSum[i] == rightSum[i]){
                index = i;
                break;
            }
        }
        return index;
    }
}

class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length == 0) return 0;
        int index = -1;
        int[] pre = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
        }
        for(int i = 1; i < nums.length; i ++){
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        for(int i = 0; i < nums.length; i ++){
            int right = sum - pre[i] - nums[i];
            if(pre[i] == right){
                index = i;
                break;
            }
        }
        return index;
    }
}