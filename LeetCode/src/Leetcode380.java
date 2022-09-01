class RandomizedSet {
    private HashMap<Integer, Integer> record;
    private List<Integer> list;
    private Random rand;

    public RandomizedSet() {
        record = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if(record.containsKey(val)) {
            return false;
        } else {
            list.add(val);
            record.put(val, list.size() - 1);
            return true;
        }
    }

    public boolean remove(int val) {
        if(record.containsKey(val)) {
            int valIndex = record.get(val);
            int lastVal = list.get(list.size() - 1);
            list.set(valIndex, lastVal);
            record.put(lastVal, valIndex);
            record.remove(val);
            list.remove(list.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */