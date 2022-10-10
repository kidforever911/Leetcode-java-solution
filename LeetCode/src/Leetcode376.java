class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 0) return 0;
        List<Integer> record = new ArrayList<>();
        for(int i = 0; i < nums.length; i ++) {
            record.add(nums[i]);
            int j = i;
            while(j < nums.length && nums[j] == nums[i]) j ++;
            i = j - 1;
        }
        if(record.size() <= 2) return record.size();
        int result = 2;
        for(int i = 1; i < record.size() - 1; i ++) {
            int a = record.get(i - 1);
            int b = record.get(i);
            int c = record.get(i + 1);
            if((b > a && b > c) || (b < a && b < c)) {
                result ++;
            }
        }
        return result;
    }
}