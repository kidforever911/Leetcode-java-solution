class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> record = new HashSet<>();
        for(int x : nums) {
            record.add(x);
            int temp = 0;
            while(x != 0) {
                temp = temp * 10 + x % 10;
                x /= 10;
            }
            record.add(temp);
        }
        return record.size();
    }
}