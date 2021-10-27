public class Leetcode209 {
    //方法2？？？
    //slide windows
    //time complexity:o(n)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int left = 0;
            int right = -1;
            int sum = 0;
            int res = nums.length + 1;
            while(left < nums.length){
                if(right < nums.length - 1 && sum < target){
                    right++;
                    sum += nums[right];

                }else{
                    sum -= nums[left];
                    left++;
                }
                if(sum >= target){
                    res = Math.min(res, right - left + 1);
                }
            }
            if(res == nums.length + 1)
                return 0;
            return res;
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


}
