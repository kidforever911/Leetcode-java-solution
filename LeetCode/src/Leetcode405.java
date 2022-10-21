class Solution {
    public String toHex(int num) {
        if(num == 0) return "0";
        StringBuilder result = new StringBuilder();
        String record = "0123456789abcdef";
        while(num != 0) {
            result.append(record.charAt(num & 0xf));
            num >>>= 4;
        }
        return result.reverse().toString();
    }
}