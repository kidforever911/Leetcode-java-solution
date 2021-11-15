import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s.length() == 0) return result;
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        LinkedList<String> record = new LinkedList<>();
        for(int j = 0; j < n; j ++){
            for(int i = 0; i <= j ; i ++){
                if(i == j) f[i][j] = true;
                else if(s.charAt(i) == s.charAt(j)){
                    if(i + 1 > j - 1 || f[i + 1][j - 1]) f[i][j] = true;
                }
            }
        }
        generatePartition(s, 0, f, record, result);
        return result;
    }

    private void generatePartition(String s, int index, boolean[][] f, LinkedList<String> record, List<List<String>> result){
        if(index == s.length()){
            result.add((LinkedList<String>)record.clone());
            return;
        }

        for(int i = index; i < s.length(); i ++){
            if(f[index][i]){
                record.addLast(s.substring(index, i + 1));
                generatePartition(s, i + 1, f, record, result);
                record.removeLast();
            }
        }
        return;
    }
}