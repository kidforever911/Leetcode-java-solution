class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> record = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int x : nums2) {
            q.add(x);
            while(!q.isEmpty() && q.peek() < x) {
                record.put(q.poll(), x);
            }
        }
        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i ++) {
            result[i] = record.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> record = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = nums2.length - 1; i >= 0; i --) {
            while(!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) record.put(nums2[i], stack.peek());
            stack.add(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i ++) {
            result[i] = record.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}