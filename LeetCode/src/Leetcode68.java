import java.util.ArrayList;
import java.util.List;

//最后一行左对齐
//该行只包含一个单词，该行左对齐
//正常情况
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < words.length; i ++){
            int j = i + 1;
            int len = words[i].length();
            while(j < words.length && len + 1 + words[j].length() <= maxWidth)
                len += 1 + words[j ++].length();

            String line = "";
            if(j == words.length || j == i + 1){
                //左对齐
                line += words[i];
                for(int k = i + 1; k < j; k ++) line += ' ' + words[k];
                while(line.length() < maxWidth) line += ' ';
            }else{
                //右对齐
                int spaceNumber = j - i - 1, leftSpace = maxWidth - len + spaceNumber;
                line += words[i];
                int k = 0;
                while(k < leftSpace % spaceNumber){
                    line += generateBlank(leftSpace / spaceNumber + 1) + words[i + k + 1];
                    k++;
                }
                while(k < spaceNumber){
                    line += generateBlank(leftSpace / spaceNumber) + words[i + k + 1];
                    k++;
                }
            }
            result.add(line);
            i = j - 1;
        }
        return result;
    }

    private String generateBlank(int a){
        String s = "";
        for(int i = 0; i < a; i ++){
            s += ' ';
        }
        return s;
    }
}