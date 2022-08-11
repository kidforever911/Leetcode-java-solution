class Solution {
    public String removeDuplicates(String s, int k) {
        if(s.length() == 0) return "";
        StringBuilder result = new StringBuilder();
        Stack<int[]> record = new Stack<>();
        for(char c : s.toCharArray()) {
            int idx = c - 'a';
            if(record.isEmpty() || record.peek()[0] != idx) record.push(new int[]{idx, 1});
            else{
                record.peek()[1] ++;
                record.peek()[1] %= k;
                if(record.peek()[1] == 0) {
                    record.pop();
                }
            }
        }
        for(int[] pair : record) {
            int count = pair[1];
            for(int i = 0; i < count; i ++) {
                result.append((char)(pair[0] + 'a'));
            }
        }
        return result.toString();
    }
}