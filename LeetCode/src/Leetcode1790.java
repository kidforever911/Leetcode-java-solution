class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        StringBuilder str1 = new StringBuilder(s1);
        StringBuilder str2 = new StringBuilder(s2);
        for(int i = 0; i < str1.length(); i ++) {
            for(int j = i; j < str1.length(); j ++) {
                swap(str1, i, j);
                if((str1.toString()).equals(str2.toString())) return true;
                swap(str1, j, i);
            }
        }
        return false;
    }
    private void swap(StringBuilder str, int i, int j) {
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }
}

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        int[] arr = new int[26];
        for(int i = 0; i < s1.length(); i ++) {
            arr[s1.charAt(i) - 'a'] ++;
            arr[s2.charAt(i) - 'a'] --;
        }
        for(int i = 0; i < arr.length; i ++) {
            if(arr[i] != 0) {
                return false;
            }
        }
        int count = 0;
        for(int i = 0; i < s1.length(); i ++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                count ++;
            }
        }
        return count == 2;
    }
}