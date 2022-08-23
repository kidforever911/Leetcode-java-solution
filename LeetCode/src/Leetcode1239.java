class Solution {
    private int result = 0;
    public int maxLength(List<String> arr) {
        dfs(0, arr, "");
        return result;
    }
    private void dfs(int index, List<String> arr, String record) {
        if(!isUnique(record)) {
            return;
        }
        result = Math.max(result, record.length());
        for(int i = index; i < arr.size(); i ++) {
            dfs(i, arr, record + arr.get(i));
        }
        return;
    }
    private boolean isUnique(String s) {
        HashSet<Character> hash = new HashSet<>();
        for(char c : s.toCharArray()) {
            if(hash.contains(c)) {
                return false;
            }
            hash.add(c);
        }
        return true;
    }
}