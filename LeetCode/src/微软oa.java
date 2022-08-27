//找到一个数组中最大子数组，要求任意两个数的差值为m倍数
public class Main {
    public static int largestMAlignedSubset(int[] nums, int M) {
        if (M <= 1) return nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int rem = n < 0 ? n % M + M : n % M;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        int res  = 0;
        for (int rem : map.keySet()) {
            res = Math.max(res, map.get(rem));
        }
        return res;
    }
}
