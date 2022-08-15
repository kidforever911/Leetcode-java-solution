class Solution {
    public int countSpecialNumbers(int n) {
        List<Integer> record = new ArrayList<>();
        while(n > 0) {
            record.add(n % 10);
            n /= 10;
        }
        Collections.reverse(record);
        int result = 0;
        for(int i = 1; i < record.size(); i ++) {
            int t = 9;
            for(int j = 0, k = 9; j < i - 1; j ++, k --) {
                t *= k;
            }
            result += t;
        }
        boolean[] used = new boolean[10];
        for(int i = 0; i < record.size(); i ++) {
            for(int j = (i == 0 ? 1 : 0); j < record.get(i); j ++) {
                if(used[j]) continue;
                int t = 1;
                for(int k = 0, u = 9 - i; k < record.size() - i - 1; k ++, u --) {
                    t *= u;
                }
                result += t;
            }
            if(used[record.get(i)]) break;
            used[record.get(i)] = true;
        }
        Set<Integer> S = new HashSet<>(record);
        if(S.size() == record.size()) result ++;
        return result;
    }
}