class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length == 0) return result;
        for(int i = 0; i < nums.length; i ++){
            result.add(nums[i]);
            while(result.size() > 1){
                int a = result.get(result.size() - 1);
                int b = result.get(result.size() - 2);
                int g = gcd(a, b);
                if(g == 1) break;
                result.remove(result.size() - 1);
                result.set(result.size() -1, a / g * b);
            }
        }
        return result;
    }

    private int gcd(int a, int b){
        return b == 0? a: gcd(b, a % b);
    }
}