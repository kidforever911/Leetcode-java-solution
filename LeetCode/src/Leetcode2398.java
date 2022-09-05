class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        Deque<Integer> record = new ArrayDeque<>();
        int result = 0;
        long sum = 0;
        for(int slow = 0, fast = 0; fast < n; fast ++) {
            sum += runningCosts[fast];
            while(record.size() > 0 && chargeTimes[record.getLast()] <= chargeTimes[fast]) {
                record.pollLast();
            }
            record.addLast(fast);
            while(record.size() > 0 && sum * (fast - slow + 1) + chargeTimes[record.getFirst()] > budget) {
                sum -= runningCosts[slow];
                if(record.peekFirst() == slow) record.pollFirst();
                slow ++;
            }
            result = Math.max(result, fast - slow + 1);
        }
        return result;
    }
}