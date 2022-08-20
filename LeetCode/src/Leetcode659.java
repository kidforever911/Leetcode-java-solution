class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> record = new HashMap<>();
        //tail记录以数字x结尾的连续子数组的个数
        HashMap<Integer, Integer> tail = new HashMap<>();
        for(int i : nums) {
            record.put(i, record.getOrDefault(i, 0) + 1);
        }
        for(int i : nums) {
            if(record.get(i) == 0) continue;
            if(tail.getOrDefault(i - 1, 0) != 0) {
                record.put(i, record.get(i) - 1);
                tail.put(i - 1, tail.get(i - 1) - 1);
                tail.put(i, tail.getOrDefault(i, 0) + 1);
            } else if(record.getOrDefault(i + 1, 0) != 0 && record.getOrDefault(i + 2, 0) != 0) {
                tail.put(i + 2, tail.getOrDefault(i + 2, 0) + 1);
                record.put(i, record.get(i) - 1);
                record.put(i + 1, record.get(i + 1) - 1);
                record.put(i + 2, record.get(i + 2) - 1);
            } else return false;
        }
        return true;
    }
}