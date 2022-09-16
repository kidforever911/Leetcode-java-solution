class Solution {
    public int partitionString(String s) {
        int result = 0;
        int[] count = new int[26];
        int slow = 0, fast = 0;
        for(; fast < s.length(); fast ++) {
            int idx = s.charAt(fast) - 'a';
            count[idx] ++;
            if(count[idx] >= 2) {
                slow = fast;
                fast -= 1;
                count = new int[26];
                result ++;
            }
        }
        return result + 1;
    }
}