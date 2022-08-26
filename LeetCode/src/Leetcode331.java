class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> record = new Stack<>();
        String[] str = preorder.split(",");
        for(String s : str) {
            while(!record.isEmpty() && record.peek().equals("#") && s.equals("#")) {
                record.pop();
                if(record.isEmpty()) return false;
                record.pop();
            }
            record.push(s);
        }
        return record.size() == 1 && record.peek().equals("#");
    }
}