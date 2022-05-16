import java.util.TreeSet;


class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> record = new TreeSet<>();
        if (nums.length == 0 || k < 0) return false;
        for (int i = 0; i < nums.length; i++) {
            if (record.ceiling((long) nums[i] - (long) t) != null && record.ceiling((long) nums[i] - (long) t) <= (long) nums[i] + (long) t) {
                return true;
            }
            record.add((long) nums[i]);
            if (record.size() == k + 1) {
                record.remove((long) nums[i - k]);
            }

        }
        return false;
    }
}
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length == 0) return false;
        TreeSet<Long> record = new TreeSet<>();
        Long x;
        for(int fast = 0, slow = 0; fast < nums.length; fast ++){
            if(fast - slow > k) record.remove((long) nums[slow ++]);
            x = record.ceiling((long) nums[fast]);
            if(x != null && x - nums[fast] <= t) return true;
            x = record.lower((long) nums[fast]);
            if(x != null && nums[fast] - x <= t) return true;
            record.add((long) nums[fast]);
        }
        return false;
    }
}

