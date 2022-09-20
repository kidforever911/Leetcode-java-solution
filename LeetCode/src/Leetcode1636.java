class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> record = new HashMap<>();
        for(int x : nums) {
            record.put(x, record.getOrDefault(x, 0) + 1);
        }
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i ++) arr[i] = nums[i];
        Arrays.sort(arr, (a, b) -> (record.get(a) == record.get(b) ? b - a : record.get(a) - record.get(b)));
        for(int i = 0; i < n; i ++) nums[i] = arr[i];
        return nums;
    }
}

class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> record = new HashMap<>();
        for(int x : nums) {
            record.put(x, record.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (record.get(a) == record.get(b) ? b - a : record.get(a) - record.get(b)));
        for(int x : record.keySet()) {
            pq.add(x);
        }
        int[] result = new int[nums.length];
        int index = 0;
        while(!pq.isEmpty()) {
            int x = pq.poll();
            int count = record.get(x);
            for(int i = 0; i < count; i ++) {
                result[index ++] = x;
            }
        }
        return result;
    }
}