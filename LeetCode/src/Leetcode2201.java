class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        if(artifacts.length == 0 || artifacts[0].length == 0 || dig.length == 0 || dig[0].length == 0) return 0;
        boolean[] diged = new boolean[n * n];
        boolean flag = false;
        for(int[] d : dig){
            int idx = d[0] * n + d[1];
            diged[idx] = true;
        }
        int result = 0;
        for(int[] a : artifacts){
            flag = true;
            for(int i = a[0]; i <= a[2] && flag; i ++){
                for(int j = a[1]; j <= a[3] && flag; j ++){
                    int idx = i * n + j;
                    flag = diged[idx];
                }
            }
            if(flag) result ++;
        }
        return result;
    }
}