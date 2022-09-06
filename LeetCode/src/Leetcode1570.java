class SparseVector {
    HashMap<Integer, Integer> record = new HashMap<>();
    int n;

    SparseVector(int[] nums) {
        n = nums.length;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] != 0) {
                record.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        if(this.record.size() == 0 || vec.record.size() == 0) return 0;
        if(this.record.size() > vec.record.size()) return vec.dotProduct(this);
        int sum = 0;
        for(int x : vec.record.keySet()) {
            if(this.record.containsKey(x)) {
                sum += vec.record.get(x) * this.record.get(x);
            }
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);