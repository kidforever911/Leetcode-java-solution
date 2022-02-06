import java.util.*;
import java.io.*;

public class Main{
    private static int N = 100010;
    private static int[] h = new int[N];
    private static int size;
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        size = n;

        for(int i = 1; i <= n; i ++){
            h[i] = in.nextInt();
        }



        for(int i = n / 2; i > 0; i --) down(i);



        while(m -- > 0){
            System.out.print(h[1] + " ");
            h[1] = h[size --];
            down(1);
        }
    }

    private static void down(int u){
        int t = u;
        int left = 2 * t;
        int right = 2 * t + 1;
        if(left <= size && h[t] > h[left]) t = left;
        if(right <= size && h[t] > h[right]) t = right;
        if(t != u){
            swap(t, u);
            down(t);
        }
    }

    private static void swap(int x, int y){
        int temp = h[x];
        h[x] = h[y];
        h[y] = temp;
    }
}