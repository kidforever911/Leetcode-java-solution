class Solution {
    public boolean winnerOfGame(String colors) {
        if(colors.length() == 0) return false;
        int countA = 0, countB = 0;
        int n = colors.length();
        char[] letters = colors.toCharArray();
        for(int i = 1; i < colors.length() - 1; i ++){
            if(letters[i] == 'A' && letters[i + 1] == 'A' && letters[i - 1] == 'A') countA ++;
            if(letters[i] == 'B' && letters[i + 1] == 'B' && letters[i - 1] == 'B') countB ++;
        }
        return countA > countB;
    }
}