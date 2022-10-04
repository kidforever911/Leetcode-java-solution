class Solution {
    public int longestStrChain(String[] words) {
        if(words.length == 0) return 0;
        int n = words.length;
        int[] f = new int[n];
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        Arrays.fill(f, 1);
        for(int i = 1; i < n; i ++) {
            for(int j = i - 1; j >= 0; j --) {
                if(check(words[i], words[j])) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        int result = 0;
        for(int i = 0; i < n; i ++) {
            result = Math.max(result, f[i]);
        }
        return result;
    }

    private boolean check(String a, String b) {
        if(a.length() != b.length() + 1) return false;
        int i = 0, j = 0;
        while(i < a.length() && j < b.length()) {
            if(a.charAt(i) == b.charAt(j)) {
                i ++;
                j ++;
            } else {
                i ++;
            }
        }
        return j == b.length();
    }
}