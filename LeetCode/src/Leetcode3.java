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
        char[] letter = s.toCharArray();
        HashMap<Character, Integer> record = new HashMap<>();
        int result = 0;
        for(int i = 0, j = 0; i < s.length(); i ++){
            record.put(letter[i], record.getOrDefault(letter[i], 0) + 1);
            while(record.get(letter[i]) > 1){
                record.put(letter[j], record.get(letter[j]) - 1);
                j++;
            }
            result = Math.max(result, i - j + 1);
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



