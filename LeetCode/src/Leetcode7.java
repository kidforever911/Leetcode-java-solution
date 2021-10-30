class Solution {
    public int reverse(int x) {
        long r = 0;

        while(x != 0){
            r = r * 10 + x % 10;
            x = x / 10;
        }
        if(r >= Integer.MAX_VALUE) return 0;
        if(r <= Integer.MIN_VALUE) return 0;
        return (int)r;
    }
}


class Solution {
    public int reverse(int x) {
        int r = 0;

        while(x != 0){
            if(r > 0 && r > ((Integer.MAX_VALUE - x % 10) / 10)) return 0;
            if(r < 0 && r < ((Integer.MIN_VALUE - x % 10) / 10)) return 0;
            r = r * 10 + x % 10;
            x = x / 10;
        }
        return r;
    }
}
