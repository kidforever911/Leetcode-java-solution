class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length == 0) return result;
        int c1 = 0, c2 = 0, r1 = 0, r2 = 0;
        for(int x : nums){
            if(c1 > 0 && x == r1) c1 ++;
            else if(c2 > 0 && x == r2) c2 ++;
            else if(c1 == 0){
                r1 = x;
                c1 ++;
            }else if(c2 == 0){
                r2 = x;
                c2 ++;
            }else{
                c1 --;
                c2 --;
            }
        }
        c1 = 0;
        c2 = 0;
        for(int x : nums){
            if(x == r1) c1 ++;
            else if(x == r2) c2 ++;
        }
        int n = nums.length;
        if(c1 > n / 3) result.add(r1);
        if(c2 > n / 3) result.add(r2);
        return result;
    }
}