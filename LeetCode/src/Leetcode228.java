class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums.length == 0) return result;
        for(int i = 0; i < nums.length; i ++){
            int j = i + 1;
            while(j < nums.length && nums[j] == nums[j - 1] + 1) j ++;
            if(j == i + 1) result.add(Integer.toString(nums[i]));
            else{
                result.add(Integer.toString(nums[i]) + "->" + Integer.toString(nums[j - 1]));
            }
            i = j - 1;
        }
        return result;
    }
}