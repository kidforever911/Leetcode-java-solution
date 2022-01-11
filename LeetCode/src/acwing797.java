import java.util.*;
import java.io.BufferedInputStream;

public class Main{
    private static int N=100010;
    private static int[] arr, b;
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        arr = new int[N];
        b = new int[N];
        for(int i = 1; i <=n; i ++) arr[i] = in.nextInt();
        for(int i = 1; i <= n; i ++) insert(i, i, arr[i], b);
        while(m -- > 0){
            int left = in.nextInt();
            int right = in.nextInt();
            int c = in.nextInt();
            insert(left, right, c, b);
        }
        for(int i = 1; i <= n; i ++){
            b[i] += b[i - 1];
            System.out.print(b[i] + " ");
        }
    }

    private static void insert(int left, int right, int c, int[] b){
        b[left] += c;
        b[right + 1] -= c;
    }
}