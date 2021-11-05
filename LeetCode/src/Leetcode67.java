class Solution {
    public String addBinary(String a, String b) {
        if(a.isEmpty() && b.isEmpty()) return "";
        if(a.isEmpty()) return b;
        if(b.isEmpty()) return a;

        StringBuilder aa = new StringBuilder(a);
        StringBuilder bb = new StringBuilder(b);
        StringBuilder result = new StringBuilder();
        char[] A = aa.reverse().toString().toCharArray();
        char[] B = bb.reverse().toString().toCharArray();
        for(int i = 0, t = 0; i < A.length || i < B.length || t > 0; i ++){
            if(i < A.length) t += A[i] - '0';
            if(i < B.length) t += B[i] - '0';
            result.append(t % 2);
            t = t / 2;
        }
        return result.reverse().toString();

    }
}