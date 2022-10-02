class Solution {
    private int n;
    public void wiggleSort(int[] nums) {
        n = nums.length;
        int mid = quickSelect(nums, 0, n - 1, (n + 1) / 2);
        int l = 0;
        int r = n - 1;
        for(int i = 0; i <= r; ) {
            if(nums[getId(i)] > mid) {
                swap(nums, getId(i), getId(l));
                i ++;
                l ++;
            } else if(nums[getId(i)] == mid) {
                i ++;
            }else {
                swap(nums, getId(i), getId(r));
                r --;
            }
        }
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        if(left >= right) return nums[left];
        int x = nums[left + right >> 1], i = left - 1, j = right + 1;
        while(i < j) {
            do{
                i ++;
            }while(nums[i] < x);
            do{
                j --;
            }while(nums[j] > x);
            if(i < j) {
                swap(nums, i, j);
            }
        }
        int length = j - left + 1;
        if(k <= length) return quickSelect(nums, left, j, k);
        else return quickSelect(nums, j + 1, right, k - length);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int getId(int x) {
        return (2 * x + 1) % (n | 1);
    }
}