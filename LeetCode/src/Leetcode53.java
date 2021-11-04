class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int res = Integer.MIN_VALUE;
        for(int i = 0, last = 0; i < nums.length; i ++){
            last = nums[i] + Math.max(last, 0);
            res = Math.max(res, last);
        }
        return res;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        return divideMaxSubArray(nums, 0, n - 1);
    }

    private int divideMaxSubArray(int[] nums, int left, int right){
        if(left == right) return nums[left];

        int mid = left + right >> 1;
        int leftMax = divideMaxSubArray(nums, left, mid);
        int rightMax = divideMaxSubArray(nums, mid + 1, right);

        int leftCrossMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for(int i = mid; i >= left; i --){
            leftSum += nums[i];
            leftCrossMax = Math.max(leftCrossMax, leftSum);
        }

        int rightCrossMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for(int i = mid + 1; i <= right; i ++){
            rightSum += nums[i];
            rightCrossMax = Math.max(rightCrossMax, rightSum);
        }

        int crossMax = leftCrossMax + rightCrossMax;

        return Math.max(crossMax, Math.max(leftMax, rightMax));

    }
}