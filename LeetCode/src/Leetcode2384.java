class Solution {
    public String largestPalindromic(String num) {
        int[] map = new int[10];
        for(char c : num.toCharArray()) {
            int x = c - '0';
            map[x] ++;
        }
        int odd = -1;
        for(int i = 9; i >= 0; i --) {
            if(map[i] % 2 == 1) {
                map[i] --;
                odd = i;
                break;
            }
        }
        StringBuilder rightS = new StringBuilder();
        for(int i = 9; i >= 0; i --) {
            if(map[i] >= 2) {
                if(i == 0 && rightS.length() == 0) break;
                int temp = map[i] / 2;
                while(temp > 0) {
                    rightS.insert(0, i);
                    temp --;
                }
            }
        }
        StringBuilder leftS = new StringBuilder(rightS);
        leftS = leftS.reverse();
        if(odd == -1) {
            if(leftS.length() == 0) return "0";
            return leftS.toString() + rightS.toString();
        } else {
            return leftS.toString() + Integer.toString(odd) + rightS.toString();
        }
    }
}