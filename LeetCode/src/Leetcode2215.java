class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums1.length == 0 && nums2.length == 0) return result;
        List<Integer> record = new ArrayList<>();
        HashSet<Integer> hash1 = new HashSet<>();
        HashSet<Integer> hash2 = new HashSet<>();
        for(int i = 0; i < nums1.length; i ++){
            hash1.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i ++){
            hash2.add(nums2[i]);
        }
        for(int n : hash1){
            if(!hash2.contains(n)){
                record.add(n);
            }
        }
        result.add(new ArrayList<>(record));
        record.clear();
        for(int n : hash2){
            if(!hash1.contains(n)){
                record.add(n);
            }
        }
        result.add(new ArrayList<>(record));
        return result;
    }
}