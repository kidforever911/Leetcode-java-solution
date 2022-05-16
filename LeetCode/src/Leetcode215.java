class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0) return 0;
        int result = quickSort(nums, nums.length - k + 1, 0, nums.length - 1);
        return result;
    }

    private int quickSort(int[] nums, int k, int left, int right){
        while(left >= right) return nums[left];
        int x = nums[left + right >> 1], i = left - 1, j = right + 1;
        while(i < j){
            do{
                i ++;
            }while(nums[i] < x);
            do{
                j --;
            }while(nums[j] > x);
            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int length = j - left + 1;
        if(k <= length) return quickSort(nums, k, left, j);
        else return quickSort(nums, k - length, j + 1, right);

    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0 || k > nums.length) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (a - b));
        for(int i = 0; i < nums.length; i ++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0) return 0;

        return quickSort(nums, k - 1, 0, nums.length - 1);
    }

    private int quickSort(int[] nums, int k, int left, int right){
        while(left >= right) return nums[left];
        int x = nums[left + right >> 1], i = left - 1, j = right + 1;
        while(i < j){
            do{
                i ++;
            }while(nums[i] > x);
            do{
                j --;
            }while(nums[j] < x);
            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        if(k <= j) return quickSort(nums, k, left, j);
        else return quickSort(nums, k, j + 1, right);
    }
}