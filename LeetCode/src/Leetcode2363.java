class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, Integer> record = new TreeMap<>();
        for(int[] temp : items1) {
            record.put(temp[0], record.getOrDefault(temp[0], 0) + temp[1]);
        }
        for(int[] temp : items2) {
            record.put(temp[0], record.getOrDefault(temp[0], 0) + temp[1]);
        }
        for(Map.Entry<Integer,Integer> entry : record.entrySet()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(entry.getKey());
            temp.add(entry.getValue());
            result.add(temp);
        }
        return result;
    }
}