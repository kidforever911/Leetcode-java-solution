class Solution {
    public void sortColors(int[] nums) {
        for(int i = 0, j = 0, k = nums.length - 1; i <= k;){
            if(nums[i] == 0) swap(nums, i ++, j ++);
            else if(nums[i] == 2) swap(nums, i, k --);
            else i ++;
        }
        return;
    }

    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}

//快排扫描了多遍，所以在这无法使用
class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return;
    }
    private void quickSort(int[] nums, int left, int right){
        if(left >= right) return;
        int i = left -1, j = right + 1, mid = nums[left + right >> 1];
        while(i < j){
            do{
                i ++;
            }while(nums[i] < mid);
            do{
                j --;
            }while(nums[j] > mid);
            if(i < j){
                swap(nums, i, j);
            }
        }
        quickSort(nums, left, j);
        quickSort(nums, j + 1, right);
    }

    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}