public class Leetcode11 {
    class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int max = 0;
            while(left < right){
                int area = (right - left) * Math.min(height[left], height[right]);
                if(area > max){
                    max = area;
                }else if(height[left] < height[right]){
                    left++;
                }else{
                    right--;
                }
            }
            return max;
        }
    }
}
