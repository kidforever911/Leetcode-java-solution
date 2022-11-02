class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> record = new HashSet<>();
        for(String s : bank) record.add(s);
        HashMap<String, Integer> dist = new HashMap<>();
        Queue<String> q = new ArrayDeque<>();
        q.add(start);
        dist.put(start, 0);
        char[] chars = {'A', 'T', 'C', 'G'};
        while(!q.isEmpty()) {
            String t = q.poll();
            for(int i = 0; i < t.length(); i ++) {
                StringBuilder temp = new StringBuilder(t);
                for(char c : chars) {
                    temp.setCharAt(i, c);
                    if(record.contains(temp.toString()) && !dist.containsKey(temp.toString())) {
                        dist.put(temp.toString(), dist.getOrDefault(t, 0) + 1);
                        if(temp.toString().equals(end)) return dist.get(temp.toString());
                        q.add(temp.toString());
                    }
                }
            }
        }
        return -1;
    }
}