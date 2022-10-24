class Solution {
    public String addStrings(String num1, String num2) {
        if(num1.length() == 0 && num2.length() == 0) return "";
        String result = "";
        int t = 0, index1 = num1.length() - 1, index2 = num2.length() - 1;
        while(index1 >= 0 || index2 >= 0 || t > 0) {
            if(index1 >= 0) {
                t += num1.charAt(index1 --) - '0';
            }
            if(index2 >= 0) {
                t += num2.charAt(index2 --) - '0';
            }
            result = String.valueOf(t % 10) + result;
            t /= 10;
        }
        return result;
    }
}