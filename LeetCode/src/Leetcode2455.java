class Solution {
    public int averageValue(int[] nums) {
        int count = 0;
        int sum = 0;
        for(int x : nums) {
            if(x % 2 == 0 && x % 3 == 0) {
                sum += x;
                count ++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }
}