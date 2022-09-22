class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] arr = new int[2 * n];
        for(int i = 0; i < n; i ++) {
            arr[i] = nums[i];
            arr[i + n] = nums[i];
        }
        int[] result = new int[n];
        Stack<Integer> record = new Stack<>();
        for(int i = 2 * n - 1; i >= 0; i --) {
            while(!record.isEmpty() && record.peek() <= arr[i]) {
                record.pop();
            }
            if(i < n) {
                if(record.isEmpty()) result[i] = -1;
                else result[i] = record.peek();
            }
            record.add(arr[i]);
        }
        return result;
    }
}