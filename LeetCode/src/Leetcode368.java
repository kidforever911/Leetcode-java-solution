class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length == 0) return result;
        int n = nums.length;
        Arrays.sort(nums);
        int[] f = new int[n];
        int[] record = new int[n];
        int k = 0;
        for(int i = 0; i < n; i ++) {
            f[i] = 1;
            for(int j = 0; j < i; j ++) {
                if(nums[i] % nums[j] == 0) {
                    if(f[i] < f[j] + 1) {
                        record[i] = j;
                        f[i] = f[j] + 1;
                    }
                }
            }
            if(f[k] < f[i]) k = i;
        }
        for(int i = f[k] - 1; i >= 0; i --) {
            result.add(nums[k]);
            k = record[k];
        }
        return result;
    }
}