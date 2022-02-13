class Solution {
    //0-19的英文表示
    private String[] num019 = {
            "Zero",
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    //20-100的英文表示
    private String[] num20100 = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    private String[] numlarge = {
            "Billion", "Million", "Thousand", ""
    };
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        String result = "";
        for(int i = (int)1e9, j = 0; i > 0; i /= 1000, j ++){
            if(num >= i){
                result += getPart(num / i) + numlarge[j] + ' ';
                num %= i;
            }
        }
        while(result.charAt(result.length() - 1) == ' ') result = result.substring(0, result.length() - 1);
        return result;
    }
    //计算三位数
    public String getPart(int x){
        String result = "";
        if(x >= 100){
            result += num019[x / 100] + " Hundred ";
            x %= 100;
        }
        if(x >= 20){
            result += num20100[x / 10] + " ";
            x %= 10;
        }
        if(x > 0){
            result += num019[x] + " ";
        }
        return result;
    }
}