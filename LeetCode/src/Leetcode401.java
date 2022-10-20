class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < 1 << 10; i ++) {
            int count = 0;
            for(int j = 0; j < 10; j ++) {
                if((i >> j & 1) == 1) {
                    count ++;
                }
            }
            if(count == turnedOn) {
                int a = i >> 6, b = i & 63;
                if(a < 12 && b < 60) {
                    if(b < 10) result.add(a + ":0" + b);
                    else result.add(a + ":" + b);
                }
            }
        }
        return result;
    }
}