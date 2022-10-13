class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long result = 0l;
        HashMap<Integer, Long> record = new HashMap<>();
        for(int x : tasks) {
            result = Math.max(result + 1l, record.getOrDefault(x, 0l));
            record.put(x, result + space + 1);
        }
        return result;
    }
}