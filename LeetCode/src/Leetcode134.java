class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 0 || cost.length == 0) return 0;
        int n = gas.length;
        for(int i = 0, j = 0; i < n;){
            int left = 0;
            for(j = 0; j < n; j ++){
                int k = (i + j) % n;
                left += gas[k] - cost[k];
                if(left < 0) break;
            }
            if(j == n) return i;
            i = i + j + 1;
        }

        return -1;
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 0 || cost.length == 0) return 0;
        int n = gas.length;
        for(int i = 0, j = 0; i < n;){
            int left = 0;
            for(j = 0; j < n; j ++){
                int k = (i + j) % n;
                left += gas[k] - cost[k];
                if(left < 0) break;
            }
            if(j == n) return i;
            i = i + j + 1;
        }

        return -1;
    }
}