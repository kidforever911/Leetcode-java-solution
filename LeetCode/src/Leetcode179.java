import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        if(nums.length == 0) return "";
        if(nums.length == 1) return Integer.toString(nums[0]);
        int n = nums.length;
        String[] s = new String[n];
        for(int i = 0; i < n; i ++) s[i] = Integer.toString(nums[i]);
        Arrays.sort(s, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder result = new StringBuilder();
        for(String temp : s) result.append(temp);
        int k = 0;
        while(k + 1 < result.length() && result.charAt(k) == '0') k ++;
        return result.substring(k).toString();
    }
}