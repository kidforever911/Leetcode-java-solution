class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int result = 0;
        int n = img1.length;

        for(int i = - n + 1; i < n; i ++) {
            for(int j = - n + 1; j < n; j ++) {
                int count = 0;
                for(int x = Math.max(0, -i); x < Math.min(n, n - i); x ++) {
                    for(int y = Math.max(0, -j); y < Math.min(n, n - j); y ++) {
                        if(img1[i + x][j + y] == 1 && img2[x][y] == 1) {
                            count ++;
                        }
                    }
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}