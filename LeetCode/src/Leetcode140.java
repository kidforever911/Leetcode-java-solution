class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[n] = true;
        String path = "";
        HashSet<String> record = new HashSet<>();
        for(String temp : wordDict) {
            record.add(temp);
        }
        for(int i = n - 1; i >= 0; i --) {
            for(int j = i; j < n; j ++) {
                if(f[j + 1] && record.contains(s.substring(i, j + 1))) {
                    f[i] = true;
                    break;
                }
            }
        }
        dfs(s, 0, f, path, record, result);
        return result;
    }
    private void dfs(String s, int index, boolean[] f, String path, HashSet<String> record, List<String> result) {
        if(index == s.length()) {
            path = path.substring(0, path.length() - 1);
            result.add(path);
            return;
        }
        for(int i = index; i < s.length(); i ++) {
            if(f[i + 1] && record.contains(s.substring(index, i + 1))) {
                dfs(s, i + 1, f, path + s.substring(index, i + 1) + ' ', record, result);
            }
        }
        return;
    }
}