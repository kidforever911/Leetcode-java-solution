class Solution {
    public boolean findSubarrays(int[] nums) {
        HashSet<Integer> record = new HashSet<>();
        for(int i = 0; i < nums.length - 1; i ++) {
            int sum = nums[i] + nums[i + 1];
            if(record.contains(sum)) return true;
            record.add(sum);
        }
        return false;
    }
}

class Solution {
    public boolean findSubarrays(int[] nums) {
        boolean flag = false;
        int count = 0;
        HashMap<Integer, Integer> record = new HashMap<>();
        int sum = 0;
        for(int slow = 0, fast = 0; fast < nums.length; fast ++) {
            sum += nums[fast];
            if(fast - slow + 1 > 2) {
                sum -= nums[slow];
                slow ++;
            }
            if(fast - slow + 1 == 2) {
                record.put(sum, record.getOrDefault(sum, 0) + 1);
            }
        }
        for(int x : record.keySet()) {
            if(record.get(x) >= 2) {
                flag = true;
            }
        }
        return flag;
    }
}