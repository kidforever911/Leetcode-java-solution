class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> record = new HashMap<>();
        for(String temp : words) {
            record.put(temp, record.getOrDefault(temp, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (record.get(a) == record.get(b) ? (a.compareTo(b)) : (record.get(b) - record.get(a))));
        for(String x : record.keySet()) {
            pq.add(x);
        }
        List<String> result = new ArrayList<>();
        while(k -- > 0) {
            result.add(pq.poll());
        }
        return result;
    }
}