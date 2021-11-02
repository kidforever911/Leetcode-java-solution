class Solution {
    public String countAndSay(int n) {
        String result = "";
        if(n == 0) return result;
        result = "1";
        for(int i = 0; i < n - 1; i ++){
            String t = "";
            for(int j = 0; j < result.length();){
                int k = j + 1;
                while(k < result.length() && result.charAt(k) == result.charAt(j)) k ++;
                t += Integer.toString(k - j) + result.charAt(j);
                j = k;
            }
            result = t;
        }
        return result;
    }
}