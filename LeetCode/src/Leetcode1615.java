//数组的方法
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashSet<Integer> record[] = new HashSet[n];
        for(int i = 0; i < n; i ++) {
            record[i] = new HashSet<>();
        }
        for(int[] i : roads) {
            record[i[0]].add(i[1]);
            record[i[1]].add(i[0]);
        }
        int result = 0;
        for(int i = 0; i < n - 1; i ++) {
            for(int j = i + 1; j < n; j ++) {
                int cur = record[i].size() + record[j].size();
                if(record[i].contains(j)) {
                    cur --;
                }
                result = Math.max(cur, result);
            }
        }
        return result;
    }
}


//自己的方法
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, HashSet<Integer>> record = new HashMap<>();
        for(int i = 0; i < roads.length; i ++) {
            if(record.containsKey(roads[i][0])){
                record.get(roads[i][0]).add(roads[i][1]);
            } else {
                HashSet<Integer> temp = new HashSet<>();
                temp.add(roads[i][1]);
                record.put(roads[i][0], temp);
            }
            if(record.containsKey(roads[i][1])){
                record.get(roads[i][1]).add(roads[i][0]);
            } else {
                HashSet<Integer> temp = new HashSet<>();
                temp.add(roads[i][0]);
                record.put(roads[i][1], temp);
            }
        }
        int result = 0;
        for(int i = 0; i < n; i ++) {
            for(int j = i + 1; j < n; j ++) {
                int cur = record.getOrDefault(i, new HashSet<Integer>()).size() + record.getOrDefault(j, new HashSet<Integer>()).size();
                if(record.getOrDefault(i, new HashSet<Integer>()).contains(j)){
                    cur --;
                }
                result = Math.max(result, cur);
            }
        }
        return result;
    }
}