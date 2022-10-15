class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int left = matrix[0][0], right = matrix[row - 1][col - 1];
        while(left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            int j = col - 1;
            for(int i = 0; i < row; i ++) {
                while(j >= 0 && matrix[j][i] > mid) j --;
                count += j + 1;
            }
            if(count >= k) right = mid;
            else left = mid + 1;
        }
        return right;
    }
}