class Solution {
    public int minCost(String colors, int[] neededTime) {
        if(colors.length() == 0) return 0;
        int result = 0;
        for(int i = 0; i < colors.length(); i ++) {
            int sum = 0;
            int max = Integer.MIN_VALUE;
            int j = i;
            while(j < colors.length() && colors.charAt(j) == colors.charAt(i)) {
                sum += neededTime[j];
                max = Math.max(max, neededTime[j]);
                j ++;
            }
            if(j > i) result += sum - max;
            i = j - 1;
        }
        return result;
    }
}