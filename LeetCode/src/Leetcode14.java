class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if(strs.length == 0) return result.toString();
        for(int i = 0; i < strs[0].length(); i ++){
            char c = strs[0].charAt(i);
            for(String s : strs){
                if(s.length() <= i || s.charAt(i) != c)
                    return result.toString();
            }
            result.append(c);
        }
        return result.toString();
    }
}
