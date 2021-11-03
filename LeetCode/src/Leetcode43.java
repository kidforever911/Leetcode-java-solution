class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] A = new int[n];
        int[] B = new int[m];
        int[] C = new int[m + n];
        for(int i = n - 1; i >= 0; i --) A[n-i-1] = num1.charAt(i) - '0';
        for(int i = m - 1; i >= 0; i --) B[m-i-1] = num2.charAt(i) - '0';
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                C[i + j] += A[i] * B[j];
            }
        }
        int t= 0;
        for(int i = 0; i < C.length; i ++){
            t += C[i];
            C[i] = t % 10;
            t = t / 10;
        }
        int k = C.length - 1;
        while(k > 0 && C[k] == 0) k --;
        String result = "";
        while(k >= 0){
            result += (char)(C[k --] + '0');
        }
        return result;
    }
}