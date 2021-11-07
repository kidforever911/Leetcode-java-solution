class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        if(row == 0 || col == 0) return false;

        int findLine = row - 1;
        for(int i = 0; i < row; i ++){
            if(i > 0 && matrix[i][0] > target){
                findLine = i - 1;
                break;
            }
        }

        int left = 0;
        int right = col - 1;
        while(left < right){
            int mid = left + right >> 1;
            if(matrix[findLine][mid] >= target) right = mid;
            else left = mid + 1;
        }
        return matrix[findLine][left] == target;
    }
}