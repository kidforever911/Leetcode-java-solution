class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for(int i = 2; i <= n - 2; i ++) {
            if(!check(n, i)) return false;
        }
        return true;
    }

    private boolean check(int n, int b) {
        List<Integer> record = new ArrayList<>();
        while(n != 0) {
            record.add(n % b);
            n /= b;
        }
        for(int i = 0, j = record.size() - 1; i < j; i ++, j --) {
            if(record.get(i) != record.get(j)) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean isStrictlyPalindromic(int n) {
        return false;
    }
}