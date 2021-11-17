import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if(wordDict.size() == 0 || s.length() == 0) return result;
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        HashSet<String> record = new HashSet<>();
        for(String str : wordDict) record.add(str);
        f[n] = true;
        for(int i = n ; i >= 0; i --){
            for(int j = i; j < n; j ++){
                if(f[j + 1] && record.contains(s.substring(i, j + 1))){
                    f[i] = true;
                    break;
                }
            }
        }
        dfs(s, 0, "", f, wordDict, record, result);
        return result;
    }

    private void dfs(String s, int index, String path, boolean[] f, List<String> wordDict, HashSet<String> record, List<String> result){
        if(index == s.length()){
            path = path.substring(0, path.length() - 1);
            result.add(path);
            return;
        }
        for(int i = index; i < s.length(); i ++){
            if(f[i + 1] && record.contains(s.substring(index, i + 1))){
                dfs(s, i + 1, path + s.substring(index, i + 1) + ' ', f, wordDict, record, result);
            }
        }
        return;
    }
}
