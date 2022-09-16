//时间复杂度：o（nlgn）
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

//时间复杂度：o（klgn）
class Leaderboard {
    HashMap<Integer, Integer> playerScore;
    TreeMap<Integer, Integer> sortedScore;

    public Leaderboard() {
        playerScore = new HashMap<>();
        sortedScore = new TreeMap<>((a, b) -> (b - a));
    }

    public void addScore(int playerId, int score) {
        if(!playerScore.containsKey(playerId)) {
            playerScore.put(playerId, score);
            sortedScore.put(score, sortedScore.getOrDefault(score, 0) + 1);
        } else {
            int preScore = playerScore.get(playerId);
            int newScore = preScore + score;
            playerScore.put(playerId, newScore);
            sortedScore.put(preScore, sortedScore.get(preScore) - 1);
            if(sortedScore.get(preScore) == 0) {
                sortedScore.remove(preScore);
            }
            sortedScore.put(newScore, sortedScore.getOrDefault(newScore, 0) + 1);
        }
    }

    public int top(int K) {
        int count = 0;
        int sum = 0;
        for(int key : sortedScore.keySet()) {
            int times = sortedScore.get(key);
            for(int i = 0; i < times; i ++) {
                sum += key;
                count ++;
                if(count == K) break;
            }
            if(count == K) break;
        }
        return sum;
    }

    public void reset(int playerId) {
        int preScore = playerScore.get(playerId);
        sortedScore.put(preScore, sortedScore.get(preScore) - 1);
        if(sortedScore.get(preScore) == 0) {
            sortedScore.remove(preScore);
        }
        playerScore.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */