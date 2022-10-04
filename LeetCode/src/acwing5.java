import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int N = 12000;
        int[] v = new int[N];
        int[] w = new int[N];
        int[] f = new int[N];
        int n = in.nextInt();
        int m = in.nextInt();
        int count = 0;
        while(n -- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int s = in.nextInt();
            int k = 1;
            while(k <= s) {
                count ++;
                v[count] = a * k;
                w[count] = b * k;
                s-= k;
                k *= 2;
            }
            if(s > 0) {
                count ++;
                v[count] = a * s;
                w[count] = b * s;
            }
        }
        n = count;
        for(int i = 1; i <= n; i ++) {
            for(int j = m; j >= v[i]; j --) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        System.out.println(f[m]);
        return;
    }
}