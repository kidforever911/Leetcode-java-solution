class Solution {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> record = new HashMap<>();
        for(int x : changed) {
            if(!record.containsKey(x) || record.get(x) == 0) {
                record.put(2 * x, record.getOrDefault(2 * x, 0) + 1);
                list.add(x);
            } else {
                record.put(x, record.get(x) - 1);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i ++) {
            result[i] = list.get(i);
        }
        return result.length == changed.length / 2 ? result : new int[]{};
    }
}