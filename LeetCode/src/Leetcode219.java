import java.util.HashSet;

//滑动窗口的做法
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> record = new HashSet<>();
        if (nums.length == 0 || k < 0) return false;
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])) {
                return true;
            }
            record.add(nums[i]);
            if (record.size() == k + 1) {
                record.remove(nums[i - k]);
            }

        }
        return false;
    }
}
//hash表做法
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0) return false;
        HashMap<Integer, Integer> record = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            int x = nums[i];
            if(record.containsKey(x) && i - record.get(x) <= k) return true;
            record.put(x, i);
        }
        return false;
    }
}

