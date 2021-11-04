class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0;
        for(int i = s.length() - 1; i >= 0; i --){
            if(s.charAt(i) == ' ') continue;
            int j = i - 1;
            while(j >= 0 && s.charAt(j) != ' ') j --;
            return i - j;
        }
        return -1;
    }
}