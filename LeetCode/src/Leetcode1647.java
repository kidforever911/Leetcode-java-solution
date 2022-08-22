class Solution {
    public int minDeletions(String s) {
        int[] record = new int[26];
        HashSet<Integer> count = new HashSet<>();
        int result = 0;
        for(char c : s.toCharArray()) {
            record[c - 'a'] ++;
        }
        for(int i = 0; i < record.length; i ++) {
            int num = record[i];
            while(num > 0 && count.contains(num)) {
                num --;
                result ++;
            }
            if(num > 0) count.add(num);
        }
        return result;
    }
}