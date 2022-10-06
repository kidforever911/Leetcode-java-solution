class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length == 0) return false;
        List<Integer> record = new ArrayList<>();
        for(int x : nums) {
            if(record.isEmpty() || x > record.get(record.size() - 1)) {
                record.add(x);
                if(record.size() == 3) return true;
            } else {
                if(record.size() == 1) {
                    if(x < record.get(0)) {
                        record.set(0, x);
                    }
                }
                if(record.size() == 2) {
                    if(x < record.get(0)) {
                        record.set(0, x);
                    } else if(x > record.get(0) && record.get(1) > x) {
                        record.set(1, x);
                    }
                }
            }
        }
        return false;
    }
}

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for(int x : nums) {
            if(x < first) {
                first = x;
            } else if(x > first && x < second) {
                second = x;
            } else if(x > second) {
                return true;
            }
        }
        return false;
    }
}