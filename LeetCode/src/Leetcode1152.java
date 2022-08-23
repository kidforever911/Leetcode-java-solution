class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String, <Integer, String>> map = new HashMap<>();
        for (int i = 0; i < timestamp.length; i++) {
            if (!map.containsKey(username[i])) {
                map.put(username[i], new TreeMap<>());
            }
            TreeMap<Integer, String> timeMap = map.get(username[i]);
            timeMap.put(timestamp[i], website[i]);
            map.put(username[i], timeMap);
        }

        HashMap<String, Integer> sequenceMap = new HashMap<>();
        for (String user : map.keySet()) {
            TreeMap<Integer, String> timeMap = map.get(user);
            if (timeMap.size() < 3) {
                continue;
            } else {
                List<Integer> times = new ArrayList<>();
                for (int key : timeMap.keySet()) {
                    times.add(key);
                }
                List<String> allSeqs = formAllSeqs(times, timeMap);
                HashSet<String> visited = new HashSet<>();
                for (String seq : allSeqs) {
                    if (visited.add(seq)) {
                        sequenceMap.put(seq, sequenceMap.getOrDefault(seq, 0) + 1);
                    }
                }
            }

        }

        int count = 0;
        String result = "";
        for (String key : sequenceMap.keySet()) {
            if (sequenceMap.get(key) > count) {
                result = key;
                count = sequenceMap.get(key);
            } else if (sequenceMap.get(key) == count) {
                if (key.compareTo(result) < 0) {
                    result = key;
                }
            }
        }
        List<String> threeSeq = new ArrayList<>();
        for (String s : result.split("->")) {
            threeSeq.add(s);
        }
        return threeSeq;
    }

    private List<String> formAllSeqs(List<Integer> times, TreeMap<Integer, String> timeMap) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i + 2 < times.size(); i++) {
            for (int j = i + 1; j + 1 < times.size(); j++) {
                for (int k = j + 1; k < times.size(); k++) {
                    result.add(timeMap.get(times.get(i)) + "->" +
                            timeMap.get(times.get(j)) + "->" +
                            timeMap.get(times.get(k)));
                }
            }
        }
        return result;
    }
}