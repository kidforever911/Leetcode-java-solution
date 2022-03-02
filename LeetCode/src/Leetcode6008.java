class Solution {
    public int prefixCount(String[] words, String pref) {
        if(words.length == 0) return 0;
        int count = 0;
        for(String s : words){
            if(pre(s, pref))
                count ++;
        }
        return count;
    }

    private boolean pre(String s, String pref){
        int index = 0;
        while(index < s.length() && index < pref.length()){
            if(pref.charAt(index) == s.charAt(index)){
                index ++;
            }else{
                return false;
            }
        }
        return index == pref.length();
    }
}