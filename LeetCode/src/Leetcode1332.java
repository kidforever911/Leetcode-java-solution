class Solution {
    public int removePalindromeSub(String s) {
        if(s.equals(new StringBuilder(s).reverse().toString())) return 1;
        else return 2;
    }
}