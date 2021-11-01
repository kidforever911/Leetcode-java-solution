//任意前缀中“（”数量（>=数量“）”
//左右括号数量相等

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0) return result;
        dfs(n, 0, 0, "", result);
        return result;
    }

    private void dfs(int n, int lc, int rc, String record, List<String> result){
        if(lc == n && rc == n){
            result.add(record);
            return;
        }
        else{
            if(lc < n) dfs(n, lc + 1, rc, record + '(', result);
            //这里rc不等于lc是因为如果rc=lc时加），则会出现n=2时（））（这种情况
            if(rc < n && rc < lc) dfs(n, lc, rc + 1, record + ')', result);
        }
        return;
    }
}