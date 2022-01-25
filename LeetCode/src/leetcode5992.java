class Solution {
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int result = 0;
        for(int i = 0; i < 1 << n; i ++){
            boolean flag = true;
            for(int j = 0; j < n; j ++){
                for(int k = 0; k < n; k ++){
                    if(statements[j][k] != 2){
                        if((i >> j & 1) == 1){
                            if(statements[j][k] != (i >> k & 1)){
                                flag = false;
                            }
                        }
                    }
                }
            }
            if(flag){
                int count = 0;
                for(int m = 0; m < n; m ++){
                    if((i >> m & 1) == 1){
                        count ++;
                    }
                }
                result = Math.max(result, count);
            }
        }
        return result;

    }
}