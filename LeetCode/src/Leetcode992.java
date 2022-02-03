import java.util.HashMap;
import java.util.HashSet;
//暴力求解，超时，时间复杂度n^3
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        if(nums.length == 0) return 0;
        int result = 0;
        for(int i = k; i <= nums.length; i ++){
            int[] arr = new int[i];
            for(int j = 0; j + i - 1 < nums.length; j ++){
                int temp = j;
                for(int m = 0; m < arr.length; m ++){
                    arr[m] = nums[temp ++];
                }
                if(subarrayTrue(arr, k)){
                    result += 1;
                }
            }
        }
        return result;
    }

    private boolean subarrayTrue(int[] arr, int k){
        HashSet<Integer> record = new HashSet<>();
        int count = 0;
        for(int i = 0; i < arr.length; i ++){
            record.add(arr[i]);
        }
        for(int nums : record){
            k --;
        }
        if(k == 0){
            return true;
        }else{
            return false;
        }
    }
}
//双指针时间复杂度n^2，还是超时了
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        if(nums.length == 0) return 0;
        HashMap<Integer, Integer> record = new HashMap<>();
        int result = 0;
        for(int slow = 0, fast = 0; slow < nums.length; ){
            int temp = k;
            record.put(nums[fast], record.getOrDefault(nums[fast], 0) + 1);
            if(fast - slow + 1 >= k){
                for(int n : record.keySet()){
                    temp --;
                }
                if(temp == 0){
                    result += 1;
                }
            }
            if(fast == nums.length - 1){
                slow ++;
                fast = slow;
                record = new HashMap<>();
            }else{
                fast ++;
            }
        }
        return result;
    }
}

//双指针 时间复杂度n
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        if(nums.length == 0) return 0;
        int result = 0;
        HashMap<Integer, Integer> record1 = new HashMap<>();
        HashMap<Integer, Integer> record2 = new HashMap<>();
        for(int i = 0, j1 = 0, j2 = 0, count1 = 0, count2 = 0; i < nums.length; i ++){
            if(record1.getOrDefault(nums[i], 0) == 0) count1 ++;
            record1.put(nums[i], record1.getOrDefault(nums[i], 0) + 1);
            while(count1 > k){
                record1.put(nums[j1], record1.get(nums[j1]) - 1);
                if(record1.getOrDefault(nums[j1], 0) == 0) count1 --;
                j1 ++;
            }

            if(record2.getOrDefault(nums[i], 0) == 0) count2 ++;
            record2.put(nums[i], record2.getOrDefault(nums[i], 0) + 1);
            while(count2 >= k){
                record2.put(nums[j2], record2.get(nums[j2]) - 1);
                if(record2.getOrDefault(nums[j2], 0) == 0) count2 --;
                j2 ++;
            }
            result += j2 - j1;
        }
        return result;
    }
}