class Solution {
    public int countElements(int[] nums) {
        if(nums.length <= 2) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int result = 0;
        for(int i : nums){
            if(i != min && i != max){
                result ++;
            }
        }
        return result;
    }
}