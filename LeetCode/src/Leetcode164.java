class Range{
    int minv;
    int maxv;
    boolean used;
    Range(){
        minv = Integer.MAX_VALUE;
        maxv = Integer.MIN_VALUE;
        used = false;
    }
}

class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int Min = Integer.MAX_VALUE, Max = Integer.MIN_VALUE;
        for(int x : nums){
            Min = Math.min(Min, x);
            Max = Math.max(Max, x);
        }

        if(n < 2 || Min == Max) return 0;

        Range[] r = new Range[n - 1];
        for(int i = 0; i < n - 1; i ++) r[i] = new Range();

        for(int i = 0; i < n; i ++){
            int t = nums[i];
            if(t == Min) continue;
            int len = (Max - Min + n - 2) / (n - 1);

            int k = (t - Min - 1) / len;
            r[k].minv = Math.min(r[k].minv, t);
            r[k].maxv = Math.max(r[k].maxv, t);
            r[k].used = true;

        }

        int result = 0;
        for(int i = 0, last = Min; i < n - 1; i ++){
            if(r[i].used){
                result = Math.max(result, r[i].minv - last);
                last = r[i].maxv;

            }
        }
        return result;
    }
}