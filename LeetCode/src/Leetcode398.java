class Solution {
    private HashMap<Integer, List<Integer>> record;
    private Random rand;
    public Solution(int[] nums) {
        record = new HashMap<>();
        rand = new Random();
        for(int i = 0; i < nums.length; i ++) {
            if(!record.containsKey(nums[i])) {
                record.put(nums[i], new ArrayList<>());
            }
            record.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        return record.get(target).get(rand.nextInt(record.get(target).size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */