import java.util.Stack;

class Solution {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int result = 0;

        Stack<Integer> record = new Stack<>();
        for(int i = 0; i < height.length; i ++){
            int last = 0;
            while(!record.isEmpty() && height[i] >= height[record.peek()]){
                result += (i - record.peek() - 1) * (height[record.peek()] - last);
                last = height[record.peek()];
                record.pop();
            }

            if(!record.isEmpty()) result += (i - record.peek() - 1) * (height[i] - last);
            record.push(i);
        }
        return result;
    }
}