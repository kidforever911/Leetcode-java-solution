class Solution {
    public int maximumSwap(int num) {
        StringBuilder s = new StringBuilder(Integer.toString(num));
        for(int i = 0; i < s.length() - 1; i ++) {
            if(s.charAt(i) < s.charAt(i + 1)) {
                int k = i + 1;
                for(int j = i + 1; j < s.length(); j ++) {
                    if(s.charAt(j) >= s.charAt(k)) {
                        k = j;
                    }
                }
                for(int j = 0; ; j ++) {
                    if(s.charAt(j) < s.charAt(k)) {
                        char temp = s.charAt(j);
                        s.setCharAt(j, s.charAt(k));
                        s.setCharAt(k, temp);
                        return Integer.parseInt(s.toString());
                    }
                }
            }
        }
        return num;
    }
}