import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0 || wordDict.size() == 0) return false;
        HashSet<String> record = new HashSet<>();
        for(String str : wordDict) record.add(str);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        //将s下标和f下标统一，方便写状态转换方程
        s = ' ' + s;
        dp[0] = true;
        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= i; j ++){
                if(dp[j - 1] && record.contains(s.substring(j , i + 1))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}