//o(nlogn)
class Solution {
    public int maxWidthRamp(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        Integer[] index = new Integer[n];
        for(int i = 0; i < n; i ++) index[i] = i;
        Arrays.sort(index, (a, b) -> (nums[a] == nums[b] ? (a - b) : (nums[a] - nums[b])));
        int result = 0;
        for(int i = 0, j = index[0]; i < n; i ++) {
            result = Math.max(result, index[i] - j);
            j = Math.min(j, index[i]);
        }
        return result;
    }
}
//o(n)
class Solution {
    public int maxWidthRamp(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int[] minArray = new int[n];
        int min = nums[0];
        int[] maxArray = new int[n];
        int max = nums[n - 1];
        for(int i = 0; i < n; i ++) {
            if(nums[i] < min) {
                min = nums[i];
            }
            minArray[i] = min;
        }
        for(int i = n - 1; i >= 0; i --) {
            if(nums[i] > max) {
                max = nums[i];
            }
            maxArray[i] = max;
        }
        int result = 0;
        for(int i = 0, j = 0; i < minArray.length && j < maxArray.length; ) {
            if(minArray[i] <= maxArray[j]) {
                result = Math.max(result, j - i);
                j ++;
            } else {
                i ++;
            }
        }

        return result;
    }
}