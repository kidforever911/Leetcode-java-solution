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

class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        if(height.length == 0) return result;
        for(int l = 0, r = height.length - 1; l < r;){
            int area = Math.min(height[l], height[r]) * (r - l);
            if(area > result) result = area;
            if(height[l] > height[r]) r --;
            else l ++;
        }
        return result;
    }
}
