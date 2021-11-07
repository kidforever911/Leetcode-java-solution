class Solution {
    public String simplifyPath(String path) {
        if(path.length() == 0) return "";
        if(path.charAt(path.length() - 1) != '/') path += '/';
        StringBuilder result = new StringBuilder();
        String current = "";
        char[] letters = path.toCharArray();
        for(int i = 0; i < letters.length; i ++){
            if(letters[i] != '/') current += letters[i];
            else{
                if(current.equals("..")){
                    while(result.length() > 0 && result.charAt(result.length() - 1) != '/') result.deleteCharAt(result.length() - 1);
                    if(result.length() > 0) result.deleteCharAt(result.length() -  1);
                }else if(!current.equals(".") && !current.equals("")){
                    result.append("/");
                    result.append(current);
                }
                current = "";
            }

        }
        if(result.length() == 0) result.append("/");
        return result.toString();
    }
}