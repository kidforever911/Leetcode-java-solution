class Solution {
    public int[] secondGreaterElement(int[] nums) {
        if(nums.length == 0) return nums;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for(int i = 0; i < nums.length; i ++) {
            while(!s2.isEmpty() && nums[s2.peek()] < nums[i]) {
                result[s2.pop()] = nums[i];
            }
            while(!s1.isEmpty() && nums[s1.peek()] < nums[i]) {
                temp.add(s1.pop());
            }
            while(!temp.isEmpty()) {
                s2.add(temp.pop());
            }
            s1.add(i);
        }

        return result;
    }
}