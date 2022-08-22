class Solution {
    public int minimumRecolors(String blocks, int k) {
        if(blocks.length() == 0) return 0;
        int result = 0;
        int count = 0;
        for(int slow = 0, fast = 0; fast < blocks.length(); fast ++) {
            if(blocks.charAt(fast) == 'B') {
                count ++;
            }
            if(fast - slow + 1 > k) {
                if(blocks.charAt(slow) == 'B') {
                    count --;
                    slow ++;
                } else {
                    slow ++;
                }
            }
            result = Math.max(result, count);
        }
        return k - result;
    }
}