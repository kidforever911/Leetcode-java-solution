class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int m = queries.length;
        int n = nums.length;
        int[] result = new int[m];
        Arrays.sort(nums);
        for(int i = 0; i < m; i ++) {
            int target = queries[i];
            int sum = 0;
            for(int slow = 0, fast = 0; fast < nums.length; fast ++) {
                sum += nums[fast];
                while(sum > target) {
                    sum -= nums[slow];
                    slow ++;
                }
                result[i] = Math.max(result[i], fast - slow + 1);
            }
        }
        return result;
    }
}

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i ++) {
            nums[i] += nums[i - 1];
        }
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i ++) {
            int target = queries[i];
            int left = 0, right = nums.length - 1;
            while(left < right) {
                int mid = left + right + 1 >> 1;
                if(nums[mid] <= target) left = mid;
                else right = mid - 1;
            }
            if(left < nums.length && nums[left] <= target) left ++;
            result[i] = left;
        }
        return result;
    }
}

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i ++) {
            int k = 0, s = 0;
            while(k < nums.length && s + nums[k] <= queries[i]) {
                s += nums[k ++];
            }
            result[i] = k;
        }
        return result;
    }
}