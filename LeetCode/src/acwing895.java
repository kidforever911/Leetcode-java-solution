import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int N = 1010;
        int[] arr = new int[N];
        int[] f = new int[N];
        for(int i = 1; i <= n; i ++) {
            arr[i] = in.nextInt();
            f[i] = 1;
        }
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j < i; j ++) {
                if(arr[i] > arr[j]) f[i] = Math.max(f[i], f[j] + 1);
            }
        }
        int result = 0;
        for(int i = 1; i <= n; i ++) result = Math.max(result, f[i]);
        System.out.println(result);
        return;
    }
}

import java.util.*;
        import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int N = 1010;
        int[] arr = new int[N];
        int[] f = new int[N];
        int[] g = new int[N];
        for(int i = 1; i <= n; i ++) {
            arr[i] = in.nextInt();
            f[i] = 1;
            g[i] = 0;
        }
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j < i; j ++) {
                if(arr[i] > arr[j]) {
                    if(f[i] < f[j] + 1) {
                        f[i] = f[j] + 1;
                        g[i] = j;
                    }
                }
            }
        }
        int k = 1;
        for(int i = 1; i <= n; i ++) {
            if(f[k] < f[i]) {
                k = i;
            }
        }
        System.out.println(f[k]);
        for(int i = 0, length = f[k]; i < length; i ++) {
            System.out.print(arr[k] + " ");
            k = g[k];
        }
        return;
    }
}