class Solution {
    public String intToRoman(int num) {
        String result = "";
        if(num == 0) return result;
        int[] values = {
                1000,
                900, 500, 400, 100,
                90, 50, 40, 10,
                9, 5, 4, 1
        };
        String[] symbol = {
                "M",
                "CM", "D", "CD", "C",
                "XC", "L", "XL", "X",
                "IX", "V", "IV", "I"
        };

        for(int i = 0; i < 13; i ++){
            while(num >= values[i]){
                result += symbol[i];
                num -= values[i];
            }
        }
        return result;
    }
}