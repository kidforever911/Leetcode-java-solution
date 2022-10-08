class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0) return result;
        int n = nums1.length, m = nums2.length;
        PriorityQueue<int[]> record = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for(int i = 0; i < m; i ++) {
            record.add(new int[]{nums1[0] + nums2[i], 0, i});
        }
        while(k -- > 0 && !record.isEmpty()) {
            int[] temp = record.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[temp[1]]);
            list.add(nums2[temp[2]]);
            result.add(new ArrayList<>(list));
            if(temp[01] + 1 < n) record.add(new int[]{nums1[temp[1] + 1] + nums2[temp[2]], temp[1] + 1, temp[2]});
        }
        return result;
    }
}