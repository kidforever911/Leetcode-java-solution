import java.util.TreeSet;

public class Leetcode349 {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            TreeSet<Integer> record = new TreeSet<Integer>();
            for(int num : nums1){
                record.add(num);
            }
            TreeSet<Integer> result = new TreeSet<>();
            for(int num : nums2){
                if(record.contains(num))
                    result.add(num);
            }
            int index = 0;
            int[] answer = new int[result.size()];
            for(int num : result){
                answer[index++] = num;
            }
            return answer;
        }
    }
}
