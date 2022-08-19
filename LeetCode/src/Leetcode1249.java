class Solution {
    public String minRemoveToMakeValid(String s) {
        if(s.length() == 0) return "";
        Stack<Integer> record = new Stack<>();
        for(int i = 0; i < s.length(); i ++) {
            if(Character.isAlphabetic(s.charAt(i))) continue;
            if(s.charAt(i) == '(') {
                record.add(i);
            } else {
                if(!record.isEmpty() && s.charAt(record.peek()) == '(') {
                    record.pop();
                } else {
                    record.add(i);
                }
            }
        }
        HashSet<Integer> set = new HashSet<>(record);
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i ++) {
            if(!set.contains(i))
                result.append(s.charAt(i));
        }
        return result.toString();
    }
}