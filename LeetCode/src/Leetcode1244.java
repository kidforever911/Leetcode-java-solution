class Leaderboard {
    private HashMap<Integer, Integer> record;
    private PriorityQueue<Integer> pq;

    public Leaderboard() {
        record = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        record.put(playerId, record.getOrDefault(playerId, 0) + score);
    }

    public int top(int K) {
        int result = 0;
        pq = new PriorityQueue<>((a, b) -> (b - a));
        for(int num : record.values()) {
            pq.add(num);
        }
        while(K -- > 0) {
            result += pq.poll();
        }
        return result;
    }

    public void reset(int playerId) {
        record.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */