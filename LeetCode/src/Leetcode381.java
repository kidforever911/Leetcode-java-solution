class RandomizedCollection {
    private Random rand;
    private HashMap<Integer, HashSet<Integer>> record;
    private List<Integer> list;

    public RandomizedCollection() {
        record = new HashMap<>();
        rand = new Random();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(record.containsKey(val)) {
            list.add(val);
            record.get(val).add(list.size() - 1);
            return false;
        } else {
            list.add(val);
            HashSet<Integer> temp = new HashSet<>();
            temp.add(list.size() - 1);
            record.put(val, temp);
            return true;
        }
    }

    public boolean remove(int val) {
        if(record.containsKey(val)) {
            HashSet<Integer> recordIdxVal = record.get(val);
            int lastVal = list.get(list.size() - 1);
            HashSet<Integer> recordIdxLastVal = record.get(lastVal);
            int indexVal = recordIdxVal.iterator().next();
            recordIdxVal.remove(indexVal);
            if(recordIdxVal.isEmpty()) {
                record.remove(val);
            }
            recordIdxLastVal.add(indexVal);
            recordIdxLastVal.remove(list.size() - 1);
            list.set(indexVal, lastVal);
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
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */