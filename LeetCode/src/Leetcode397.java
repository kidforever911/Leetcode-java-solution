class Solution {
    public int integerReplacement(int n) {
        return f(n);
    }

    private int f(long n) {
        if(n == 1) return 0;
        if(n % 2 == 0) return f(n / 2) + 1;
        return Math.min(f(n - 1), f(n + 1)) + 1;
    }
}

class Solution {
    private HashMap<Long, Integer> record;
    public int integerReplacement(int n) {
        record = new HashMap<>();
        return f(n);
    }

    private int f(long n) {
        if(record.containsKey(n)) {
            return record.get(n);
        }
        if(n == 1) return 0;
        if(n % 2 == 1) {
            record.put(n, 1 + Math.min(f(n - 1), f(n + 1)));
            return record.get(n);
        } else {
            record.put(n, 1 + f(n / 2));
            return record.get(n);
        }
    }
}