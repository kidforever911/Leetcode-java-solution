
//方法2？？？
//slide windows
//time complexity:o(n)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 0) return 0;
        int left = 0, right = 0;
        int length = Integer.MAX_VALUE;
        int sum = 0;
        while(left < nums.length){
            if(right < nums.length && sum < target){
                sum += nums[right ++];
            }else{
                sum -= nums[left ++];

            }
            if(sum >= target){
                length = Math.min(length, right - left);
            }
        }
        if(length == Integer.MAX_VALUE)
            return 0;
        return length;
    }
}


//o(nlogn)
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 1, j = nums.length, min = 0;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (windowExist(mid, nums, s)) {
                j = mid - 1;
                min = mid;
            } else i = mid + 1;
        }
        return min;
    }


    private boolean windowExist(int size, int[] nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= size) sum -= nums[i - size];
            sum += nums[i];
            if (sum >= s) return true;
        }
        return false;
    }
}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 0) return 0;
        int result = Integer.MAX_VALUE;
        for(int i = 0, j = 0, sum = 0; i < nums.length; i ++){
            sum += nums[i];
            while(sum - nums[j] >= target) sum -= nums[j ++];
            if(sum >= target) result = Math.min(result, i - j + 1);
        }
        if(result == Integer.MAX_VALUE) result = 0;
        return result;
    }
}



