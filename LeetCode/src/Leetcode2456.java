class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> result = new ArrayList<>();
        if(creators.length == 0 || ids.length == 0 || views.length == 0) return result;
        HashMap<String, Long> count = new HashMap<>();
        HashMap<String, List<Integer>> record = new HashMap<>();
        for(int i = 0; i < creators.length; i ++) {
            count.put(creators[i], count.getOrDefault(creators[i], 0l) + views[i]);
            if(!record.containsKey(creators[i])) {
                record.put(creators[i], new ArrayList<>());
            }
            record.get(creators[i]).add(i);
        }
        long max = Integer.MIN_VALUE;
        for(String s : count.keySet()) {
            max = Math.max(max, count.get(s));
        }

        for(String s : count.keySet()) {
            if(max == count.get(s)) {
                int maxViews = -1;
                int minIndex = -1;
                for(int index : record.get(s)) {
                    if(views[index] > maxViews) {
                        maxViews = views[index];
                        minIndex = index;
                    } else if(views[index] == maxViews) {
                        minIndex = ids[index].compareTo(ids[minIndex]) > 0 ? minIndex : index;
                    }
                }
                result.add(Arrays.asList(s, ids[minIndex]));
            }
        }

        return result;
    }
}