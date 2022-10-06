class TimeMap {
    private HashMap<String, TreeMap<Integer, String>> record;
    public TimeMap() {
        record = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!record.containsKey(key)) {
            record.put(key, new TreeMap<>());
        }
        record.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if(!record.containsKey(key)) return "";
        TreeMap<Integer, String> temp = record.get(key);
        Integer pre = temp.floorKey(timestamp);
        if(pre == null) return "";
        return temp.get(pre);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */