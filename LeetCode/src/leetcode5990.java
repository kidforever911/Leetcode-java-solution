class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length == 0) return result;
        HashMap<Integer, Integer> record = new HashMap<>();
        for(int i : nums){
            record.put(i, record.getOrDefault(i, 0) + 1);
        }
        for(int x : nums){
            if(!record.containsKey(x - 1) && !record.containsKey(x + 1) && record.get(x) == 1){
                result.add(x);
            }
        }
        return result;
    }
}