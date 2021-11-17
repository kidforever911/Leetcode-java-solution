import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        if(ratings.length == 0) return 0;
        int n = ratings.length;
        int[] f = new int[n];
        Arrays.fill(f, -1);

        int result = 0;
        for(int i = 0; i < n; i ++) result += dp(ratings, i, f);
        return result;
    }

    private int dp(int[] ratings, int x, int[] f){
        if(f[x] != -1) return f[x];
        f[x] = 1;
        if(x > 0 && ratings[x - 1] < ratings[x]) f[x] = Math.max(f[x], 1 + dp(ratings, x - 1, f));
        if(x + 1 < ratings.length && ratings[x + 1] < ratings[x]) f[x] = Math.max(f[x], 1 + dp(ratings, x + 1, f));
        return f[x];
    }
}