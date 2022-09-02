class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> record = new HashMap<>();
        for(char c : s.toCharArray()) {
            record.put(c, record.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> (record.get(b) - record.get(a)));
        for(char x : record.keySet()) {
            pq.add(x);
        }
        StringBuilder result = new StringBuilder();
        while(!pq.isEmpty()) {
            char c = pq.poll();
            int count = record.get(c);
            for(int i = 0; i < count; i ++) {
                result.append(c);
            }
        }
        return result.toString();
    }
}