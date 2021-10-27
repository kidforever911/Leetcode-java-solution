import java.util.ArrayList;
import java.util.List;

public class Leetcode438 {
    /// Sliding Window
    /// Time Complexity: O(len(p) + len(s))
    /// Space Complexity: O(1)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if(s.length() == 0 || p.length() == 0 || s.length() < p.length()) return res;
            int left = 0;
            int right = -1;
            int[] freq_s = new int[26];
            int[] freq_p = new int[26];
            for(char c : p.toCharArray()){
                freq_p[c - 'a'] += 1;
            }
            while(right + 1 < s.length()){
                right++;
                freq_s[s.charAt(right) - 'a']++;
                if((right - left + 1) > p.length()){
                    freq_s[s.charAt(left) - 'a']--;
                    left++;
                }
                if((right - left +1) == p.length() && equal(freq_s, freq_p)){
                    res.add(left);
                }
            }
            return res;
        }

        private boolean equal(int[] freq_s, int[] freq_p){
            for(int i = 0; i < freq_s.length; i++){
                if(freq_s[i] != freq_p[i]){
                    return false;
                }
            }
            return true;
        }
    }
}
