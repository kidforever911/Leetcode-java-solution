import java.util.*;
import java.io.*;

public class Main{
    private static int N = 100010, P = 131; // 1331;
    private static long[] hash = new long[N];
    private static long[] p = new long[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        String s = in.next();
        p[0] = 1;
        for(int i = 1; i <= n; i ++) {
            p[i] = p[i - 1] * P;
            hash[i] = hash[i - 1] * P + s.charAt(i - 1);
        }
        while(m -- > 0) {
            int l1 = in.nextInt();
            int r1 = in.nextInt();
            int l2 = in.nextInt();
            int r2 = in.nextInt();
            if(get(l1, r1) == get(l2, r2)) System.out.println("Yes");
            else System.out.println("No");
        }
    }
    private static long get(int l, int r) {
        return hash[r] - hash[l - 1] * p[r - l + 1];
    }
}