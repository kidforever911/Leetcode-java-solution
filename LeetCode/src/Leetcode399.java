class Solution {
    private HashSet<String> node = new HashSet<>();
    private HashMap<String, HashMap<String, Double>> record = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        for(int i = 0; i < equations.size(); i ++) {
            List<String> list = equations.get(i);
            double w = values[i];
            add(list.get(0), list.get(1), w);
            add(list.get(1), list.get(0), 1.0 / w);
        }
        for(String k : node) {
            for(String i : node) {
                for(String j : node) {
                    if(record.get(i) != null && record.get(k) != null && record.get(i).get(k) != null && record.get(k).get(j) != null) {
                        record.get(i).put(j, record.get(i).get(k) * record.get(k).get(j));
                    }
                }
            }
        }
        for(int i = 0; i < queries.size(); i ++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if(record.get(a) != null && record.get(a).get(b) != null) result[i] = record.get(a).get(b);
            else result[i] = -1.0;
        }
        return result;
    }

    private void add(String a, String b, double w) {
        node.add(a);
        node.add(b);
        if(!record.containsKey(a)) {
            record.put(a, new HashMap<String, Double>());
        }
        record.get(a).put(b, w);
    }
}