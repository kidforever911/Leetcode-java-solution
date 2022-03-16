import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//暴力求解，时间复杂度n2
class Solution {
    private int N = 1010;
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> record = new HashSet<>();
        if(nums.length == 0) return result;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == key){
                for(int j = 0; j < nums.length; j ++){
                    if(Math.abs(j - i) <= k && !record.contains(j)){
                        record.add(j);
                        result.add(j);
                    }
                }
            }
        }
        return result;
    }
}
//快慢指针，时间复杂度n
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        if(nums.length == 0) return result;
        for(int fast = 0, slow = 0; fast < nums.length; fast ++){
            if(nums[fast] == key){
                slow = Math.max(slow, fast - k);
                int end = Math.min(nums.length - 1, fast + k);
                while(slow <= end){
                    result.add(slow);
                    slow ++;
                }
            }
        }
        return result;
    }
}