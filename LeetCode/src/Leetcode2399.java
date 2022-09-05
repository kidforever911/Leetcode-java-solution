class Solution {
    public boolean checkDistances(String s, int[] distance) {
        HashMap<Integer, Integer> record = new HashMap<>();
        for(int i = 0; i < s.length(); i ++) {
            int idx = s.charAt(i) - 'a';
            if(record.containsKey(idx)) {
                record.put(idx, i - record.get(idx) - 1);
            } else {
                record.put(idx, i);
            }
        }
        for(int x : record.keySet()) {
            if(distance[x] != record.get(x)) return false;
        }
        return true;
    }
}

class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] hash = new int[26];
        for(int i = 0; i < s.length(); i ++) {
            int idx = s.charAt(i) - 'a';
            if(hash[idx] == 0) {
                hash[idx] = i + 1;
            } else if(i - hash[idx] != distance[idx]) return false;
        }
        return true;
    }
}