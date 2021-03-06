import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0) return nums;
        int n = nums.length;
        int[] result = new int[n];
        int[] p = new int[n];
        Arrays.fill(p, 1);
        for(int i = 1; i < n; i ++){
            p[i] = p[i - 1] * nums[i - 1];
        }
        int s = 1;
        for(int i = n - 1; i >= 0; i --){
            p[i] *= s;
            s *= nums[i];
        }
        return p;
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0)  return new int[0];
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        for(int i = 1; i < nums.length; i ++) result[i] = result[i - 1] * nums[i - 1];
        for(int i = n - 1, s = 1; i >= 0; i --){
            result[i] *= s;
            s *= nums[i];
        }
        return result;
    }
}