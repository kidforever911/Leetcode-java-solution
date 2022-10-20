class Solution {
    public int lengthLongestPath(String input) {
        if(input.length() == 0) return 0;
        Stack<Integer> record = new Stack<>();
        int result = 0;
        for(int i = 0, sum = 0; i < input.length(); i ++) {
            int depth = 0;
            while(i < input.length() && input.charAt(i) == '\t') {
                i ++;
                depth ++;
            }
            while(record.size() > depth) {
                sum -= record.pop();
            }
            int j = i;
            while(j < input.length() && input.charAt(j) != '\n') {
                j ++;
            }
            int length = j - i;
            record.add(length);
            sum += length;
            if(input.substring(i, j).indexOf('.') != -1) {
                result = Math.max(result, sum + record.size() - 1);
            }
            i = j;
        }
        return result;
    }
}