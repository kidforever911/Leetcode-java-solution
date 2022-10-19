class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> record = new HashSet<>();
        for(int x : nums) {
            record.add(x);
        }
        int result = Integer.MIN_VALUE;
        for(int x : nums) {
            if(record.contains(-x)) {
                result = Math.max(result, -x);
            }
        }
        return result == Integer.MIN_VALUE ? -1 : result;
    }
}