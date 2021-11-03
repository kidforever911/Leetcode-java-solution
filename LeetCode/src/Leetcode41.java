import java.util.HashSet;

class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> record = new HashSet<>();
        for(int i = 0; i < nums.length; i ++){
            record.add(nums[i]);
        }
        int result = 1;
        while(record.contains(result)) result ++;
        return result;
    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        int n = nums.length;
        for (int i = 0; i < n; i ++){
            if(nums[i] > Integer.MIN_VALUE)
                nums[i] -= 1;
        }

        for(int i = 0; i < n; i ++){
            while(nums[i] >=0 && nums[i] < n && nums[i] != i && nums[i] != nums[nums[i]]){
                swap(nums, i, nums[i]);
            }
        }

        for(int i = 0; i < n; i ++){
            if(nums[i] != i)
                return i + 1;
        }
        return n + 1;
    }

    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}