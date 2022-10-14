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
        long result = 0l;
        for(int i = 0; i < n; i ++) {
            result += arr[i] * (n - i - 1);
        }
        System.out.println(result);
    }
}