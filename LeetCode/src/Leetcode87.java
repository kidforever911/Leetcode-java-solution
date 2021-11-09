import java.util.Arrays;

class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;
        int n = s1.length();
        char[] letters1 = s1.toCharArray();
        char[] letters2 = s2.toCharArray();
        Arrays.sort(letters1);
        Arrays.sort(letters2);
        String ls1 = new String(letters1);
        String ls2 = new String(letters2);
        if (!ls1.equals(ls2)) return false;

        for(int i = 1; i <= n - 1; i ++){
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i, n), s2.substring(i, n)))
                return true;
            if(isScramble(s1.substring(0, i), s2.substring(n - i, n)) &&
                    isScramble(s1.substring(i, n), s2.substring(0, n - i)))
                return true;
        }
        return false;
    }
}

class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int n = s1.length();
        boolean[][][] f = new boolean[n][n][n + 1];
        for(int k = 1; k <= n; k ++){
            for(int i = 0; i + k - 1 < n; i ++){
                for(int j = 0; j + k - 1 < n; j ++){
                    if(k == 1){
                        if(s1.charAt(i) == s2.charAt(j)) f[i][j][k] = true;
                    }else{
                        for(int u = 1; u < k; u ++){
                            if(f[i][j][u] && f[i + u][j + u][k - u] ||
                                    f[i][j + k - u][u] && f[i + u][j][k - u]){
                                f[i][j][k] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return f[0][0][n];
    }
}

