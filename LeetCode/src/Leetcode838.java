class Solution {
    public String pushDominoes(String dominoes) {
        if(dominoes.length() == 0) return "";
        StringBuilder result = new StringBuilder();
        dominoes = 'L' + dominoes + 'R';
        int n = dominoes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0, j = 0; i < n; i ++) {
            if(dominoes.charAt(i) != '.') j = i;
            left[i] = j;
        }
        for(int i = n - 1, j = n - 1; i >= 0; i --) {
            if(dominoes.charAt(i) != '.') j = i;
            right[i] = j;
        }
        for(int i = 0; i < n; i ++) {
            char l = dominoes.charAt(left[i]);
            char r = dominoes.charAt(right[i]);
            if(l == 'L' && r == 'L') result.append('L');
            else if(l == 'R' && r == 'R') result.append('R');
            else if(l == 'L' && r == 'R') result.append('.');
            else {
                if(i - left[i] == right[i] - i) result.append('.');
                else if(i - left[i] > right[i] - i) result.append('L');
                else result.append('R');
            }
        }
        return result.substring(1, result.length() - 1).toString();
    }
}