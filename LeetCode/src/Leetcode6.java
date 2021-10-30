class Solution {
    public String convert(String s, int numRows) {
        String result = "";
        if(numRows == 1) return s;
        for(int i = 0; i < numRows; i ++){
            if(i == 0 || i == numRows - 1){
                for(int j = i; j < s.length(); j += 2 * numRows - 2){
                    result += s.charAt(j);
                }
            }else{
                for(int j = i, k = 2 * numRows - 2 - i; j < s.length() || k < s.length(); j += 2 * numRows - 2, k += 2 * numRows - 2){
                    if(j < s.length()) result += s.charAt(j);
                    if(k < s.length()) result += s.charAt(k);
                }
            }
        }

        return result;
    }
}


