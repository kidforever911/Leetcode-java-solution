class Solution {
    public String removeStars(String s) {
        Stack<Character> record = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c != '*') {
                record.add(c);
            } else {
                record.pop();
            }
        }
        StringBuilder result = new StringBuilder();
        while(!record.isEmpty()) {
            result.append(record.pop());
        }
        return result.reverse().toString();
    }
}

class Solution {
    public String removeStars(String s) {
        StringBuilder result = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == '*') {
                result.setLength(result.length() - 1);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}