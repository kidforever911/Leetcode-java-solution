class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if(nums.length == 0) return result;
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 1; i < n; i ++) {
            if(nums[i] <= nums[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for(int i = n - 2; i >= 0; i --) {
            if(nums[i] <= nums[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        for(int i = k; i >= 1 && i < n - 1 && i <= n - k; i ++) {
            if(left[i - 1] >= k - 1 && right[i + 1] >= k - 1) {
                result.add(i);
            }
        }
        return result;
    }
}