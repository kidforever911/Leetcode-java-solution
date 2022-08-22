class Solution {
    public int minimumDeletions(String s) {
        if(s.length() == 0) return 0;
        int n = s.length();
        int[] prea = new int[n + 1];
        int[] preb = new int[n + 1];
        for(int i = 1; i <= n; i ++) {
            prea[i] = prea[i - 1];
            preb[i] = preb[i - 1];
            if(s.charAt(i - 1) == 'a') {
                prea[i] ++;
            } else {
                preb[i] ++;
            }
        }
        int count = Integer.MAX_VALUE;
        for(int i = 0; i <= n; i ++) {
            int changeA = preb[i];
            int changeB = prea[n] - prea[i];
            count = Math.min(count, changeA + changeB);
        }
        return count;
    }
}