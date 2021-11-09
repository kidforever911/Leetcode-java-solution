import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        int result = 0;
        Stack<Integer> record = new Stack<>();
        int[] left  = new int[heights.length];
        int[] right = new int[heights.length];
        for(int i = 0; i < heights.length; i ++){
            while(record.size() != 0 && heights[record.peek()] >= heights[i]) record.pop();
            if(record.isEmpty()) left[i] = -1;
            else left[i] = record.peek();
            record.add(i);
        }

        record = new Stack<>();

        for(int i = heights.length - 1; i >= 0; i --){
            while(record.size() != 0 && heights[record.peek()] >= heights[i]) record.pop();
            if(record.isEmpty()) right[i] = heights.length;
            else right[i] = record.peek();
            record.add(i);
        }

        for(int i = 0; i < heights.length; i ++){
            result = Math.max(result, heights[i] * (right[i] - left[i] - 1));
        }
        return result;
    }
}