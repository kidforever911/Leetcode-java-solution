class Solution {
    private int[] arr;
    private Random rand;

    public Solution(int[] nums) {
        arr = nums;
        rand = new Random();
    }

    public int[] reset() {
        return arr;
    }

    public int[] shuffle() {
        int[] temp = arr.clone();
        for(int i = 0; i < temp.length; i ++) {
            int random = rand.nextInt(temp.length);
            int copy = temp[i];
            temp[i] = temp[random];
            temp[random] = copy;
        }
        // swap(temp, 0, rand.nextInt(temp.length));
        return temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */