import java.util.Arrays;

class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int[] result = new int[nums.length];
        Integer[] odd = new Integer[nums.length / 2];
        int[] even = new int[(nums.length + 1) / 2];
        if(nums.length == 0) return result;
        for(int i = 1, index = 0; i < nums.length; i += 2){
            odd[index] = nums[i];
            // System.out.println(odd[index]);
            index ++;
        }
        for(int i = 0, index = 0; i < nums.length; i += 2){
            even[index ++] = nums[i];
        }

        Arrays.sort(odd, (a, b)->(b - a));
        Arrays.sort(even);
        for(int i = 0, index = 0; i < nums.length; i ++){
            result[i ++] = even[index];
            if(index < odd.length) result[i] = odd[index ++];
        }
        return result;
    }
}