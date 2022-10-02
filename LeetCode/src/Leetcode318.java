class Solution {
    public int maxProduct(String[] words) {
        if(words.length == 0) return 0;
        int n = words.length;
        int[] record = new int[n];
        for(int i = 0; i < n; i ++) {
            int bit = 0;
            for(char c : words[i].toCharArray()) {
                bit |= 1 << (c - 'a');
            }
            record[i] = bit;
        }
        int result = 0;
        for(int i = 0; i < n; i ++) {
            for(int j = i + 1; j < n; j ++) {
                if((record[i] & record[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }
}