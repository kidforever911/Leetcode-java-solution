import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] f = new int[m][n];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(matrix[i][j] == '1'){
                    if(i > 0) f[i][j] = 1 + f[i - 1][j];
                    else f[i][j] = 1;
                }
            }
        }
        int result = 0;
        for(int i = 0; i < m; i ++){
            result = Math.max(result, largestRectangleArea(f[i]));
        }
        return result;
    }

    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        int result = 0;
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Stack<Integer> record = new Stack<>();
        for(int i = 0; i < len; i ++){
            while(!record.isEmpty() && heights[record.peek()] >= heights[i]) record.pop();
            if(record.isEmpty()) left[i] = -1;
            else left[i] = record.peek();
            record.add(i);
        }

        record = new Stack<>();
        for(int i = len - 1; i >= 0; i --){
            while(!record.isEmpty() && heights[record.peek()] >= heights[i]) record.pop();
            if(record.isEmpty()) right[i] = len;
            else right[i] = record.peek();
            record.add(i);
        }

        for(int i = 0; i < len; i ++){
            result = Math.max(result, heights[i] * (right[i] - left[i] - 1));
        }
        return result;
    }
}