class Solution {
    public boolean equalFrequency(String word) {
        if(word.length() == 0) return false;
        for(int i = 0; i < word.length(); i ++) {
            if(check(word, i)) return true;
        }
        return false;
    }

    private boolean check(String word, int index) {
        int[] count = new int[26];
        for(int i = 0; i < word.length(); i ++) {
            if(i == index) continue;
            count[word.charAt(i) - 'a'] ++;
        }
        int freq = 0;
        for(int i = 0; i < 26; i ++) {
            if(count[i] > 0) {
                if(freq == 0) freq = count[i];
                else if(freq != count[i]) return false;
            }
        }
        return true;
    }
}