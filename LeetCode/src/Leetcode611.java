class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(int i = 0; i < nums.length - 2; i ++) {
            for(int j = i + 1; j < nums.length - 1; j ++) {
                //找到大于Math.abs(nums[i] - nums[j])的最小值的下标
                int leftIndex = findLeft(nums, Math.abs(nums[i] - nums[j]), j + 1);
                if(nums[leftIndex] <= Math.abs(nums[i] - nums[j])) continue;
                //找到小于nums[i] + nums[j]的最大值的下标
                int rightIndex = findRight(nums, nums[i] + nums[j], j + 1);
                if(nums[rightIndex] >= (nums[i] + nums[j])) continue;
                result += rightIndex - leftIndex + 1;
            }
        }
        return result;
    }

    private int findLeft(int[] nums, int target, int left) {
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + right >> 1;
            if(nums[mid] > target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private int findRight(int[] nums, int target, int left) {
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + right + 1 >> 1;
            if(nums[mid] < target) left = mid;
            else right = mid - 1;
        }
        return left;
    }
}