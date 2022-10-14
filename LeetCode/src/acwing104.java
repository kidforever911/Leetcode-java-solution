import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int result = 0;
        for(int i = 0; i < n; i ++) result += Math.abs(arr[i] - arr[n / 2]);
        System.out.println(result);
    }
}