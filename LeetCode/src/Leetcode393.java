class Solution {
    public boolean validUtf8(int[] data) {
        for(int i = 0; i < data.length; i ++) {
            if(get(data[i], 7) == 0) continue;
            int k = 0;
            while(k <= 4 && get(data[i], 7 - k) == 1) k ++;
            if(k == 1 || k > 4) return false;

            for(int j = 1; j < k; j ++) {
                int t = i + j;
                if(t >= data.length) return false;
                if(get(data[t], 7) != 1 || get(data[t], 6) != 0) return false;
            }
            i += k - 1;
        }
        return true;
    }

    private int get(int x, int k) {
        return x >> k & 1;
    }
}