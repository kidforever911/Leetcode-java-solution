class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);
        return (solve(nums, target, 0) + solve(nums, target, 1)) / 2;
    }

    private long solve(int[] nums, int[] target, int x) {
        long result = 0;
        for(int i = 0, j = 0; ; i ++, j ++) {
            while(i < nums.length && nums[i] % 2 != x) i ++;
            while(j < target.length && target[j] % 2 != x) j ++;
            if(i == nums.length || j == target.length) break;
            result += Math.abs(nums[i] - target[j]) / 2;
        }
        return result;
    }
}