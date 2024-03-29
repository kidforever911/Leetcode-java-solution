class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0) return "";
        int n = s.length();
        char[] letters = new StringBuilder(s).reverse().toString().toCharArray();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < n; i ++){
            StringBuilder temp = new StringBuilder();
            while(i < n && letters[i] == ' ') i ++;
            while(i < n && letters[i] != ' ') temp.append(letters[i ++]);
            if(temp.length() > 0){
                result.append(temp.reverse());
                result.append(' ');
            }
        }
        if(result.charAt(result.length() - 1) == ' ') result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}

class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0) return "";
        int n = s.length();
        String result = "";
        for(int i = n - 1, j = n - 1; i >= 0; i = j){
            while(j >= 0 && s.charAt(j) != ' ') j --;
            String temp = s.substring(j + 1, i + 1);
            result += temp + ' ';
            while(j >= 0 && s.charAt(j) == ' ') j --;
        }
        return result.trim();
    }
}

class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0) return "";
        StringBuilder result = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i --) {
            int j = i;
            while(j >= 0 && s.charAt(j) == ' ') j --;
            if(j < 0) break;
            int k = j;
            while(k >= 0 && s.charAt(k) != ' ') k --;
            result.append(s.substring(k + 1, j + 1)).append(" ");
            i = k;
        }
        return result.deleteCharAt(result.length() - 1).toString();
    }
}