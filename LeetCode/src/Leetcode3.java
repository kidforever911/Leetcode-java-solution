import java.util.HashMap;


class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int n = s.length();
        char[] letters = s.toCharArray();

        int fast = 0, slow = 0, max = 0;

        HashMap<Character, Integer> lastOccurrence = new HashMap<>();

        for (; fast < n; fast++) {
            char curr = letters[fast];
            if (lastOccurrence.containsKey(curr)) {
                slow = Math.max(slow, lastOccurrence.get(curr) + 1);
            }
            lastOccurrence.put(curr, fast);
            max = Math.max(max, fast - slow + 1);
        }
        return max;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        char[] letters = s.toCharArray();
        int result = 0;
        HashMap<Character, Integer> record = new HashMap<>();
        //双指针初始位置为开头
        for(int slow = 0, fast = 0; fast < s.length(); fast ++){
            record.put(letters[fast], record.getOrDefault(letters[fast], 0) + 1);
            //直到移动到无重复字符
            while(record.get(letters[fast]) > 1){
                //如果slow-fast区间出现重复字符，slow向右移动
                record.put(letters[slow], record.get(letters[slow]) - 1);
                slow ++;
            }
            result = Math.max(result, fast - slow + 1);
        }
        return result;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int left = 0;
        int right = -1;
        char[] letters = s.toCharArray();
        int max = 0;
        while (left < letters.length) {
            if (right + 1 < letters.length && freq[letters[right + 1]] == 0) {
                right++;
                freq[letters[right]]++;
            } else {
                freq[letters[left]]--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}



