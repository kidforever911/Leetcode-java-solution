class Solution {
    public int daysBetweenDates(String date1, String date2) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] arr1 = stringToDate(date1);
        int[] arr2 = stringToDate(date2);
        int allDate1 = arr1[0] * 365 + arr1[2];
        for(int i = 0; i < arr1[1] - 1; i ++) {
            allDate1 += months[i];
        }
        allDate1 += countLeapYear(arr1[0], arr1[1]);
        int allDate2 = arr2[0] * 365 + arr2[2];
        for(int i = 0; i < arr2[1] - 1; i ++) {
            allDate2 += months[i];
        }
        allDate2 += countLeapYear(arr2[0], arr2[1]);
        return Math.abs(allDate2 - allDate1);
    }
    private int[] stringToDate(String s) {
        String[] str = s.split("-");
        int[] arr = new int[str.length];
        arr[0] = Integer.parseInt(str[0]);
        arr[1] = Integer.parseInt(str[1]);
        arr[2] = Integer.parseInt(str[2]);
        return arr;
    }
    private int countLeapYear(int year, int month) {
        if(month <= 2) {
            year --;
        }
        return year / 4 + year / 400 - year / 100;
    }
}