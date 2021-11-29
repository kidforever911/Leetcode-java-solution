class Solution {
    public String replaceSpaces(StringBuffer str) {
        if(str.length() == 0) return "";
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < str.length(); i ++){
            if(str.charAt(i) == ' ')
                result.append("%20");
            else
                result.append(str.charAt(i));
        }
        return result.toString();
    }
}