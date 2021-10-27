import java.util.HashMap;

public class Leetcode454 {
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            if(nums1.length == 0 || nums2.length == 0 || nums3.length ==0 || nums4.length == 0){
                return 0;
            }

            HashMap<Integer, Integer> record = new HashMap<>();
            for(int i = 0; i < nums3.length; i++){
                for(int j = 0; j < nums4.length; j++){
                    int sum = nums3[i] + nums4[j];
                    if(record.containsKey(sum)){
                        record.put(sum, record.get(sum) + 1);
                    }else{
                        record.put(sum, 1);
                    }
                }
            }
            int result = 0;
            for(int i = 0; i < nums1.length; i++){
                for(int j = 0; j < nums2.length; j++){
                    if(record.containsKey(0 - nums1[i] - nums2[j])){
                        result += record.get(0 - nums1[i] - nums2[j]);
                    }
                }
            }
            return result;

        }
    }
}
