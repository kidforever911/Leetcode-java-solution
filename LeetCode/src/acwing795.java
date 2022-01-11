import java.util.*;
import java.io.BufferedInputStream;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = in.nextInt();
        }
        int[] S = new int[n + 1];
        S[0] = 0;
        for(int i = 1; i <= n; i ++){
            S[i] = S[i - 1] + arr[i - 1];
        }
        while(m -- > 0){
            int left = in.nextInt();
            int right = in.nextInt();
            System.out.println(S[right] - S[left - 1]);
        }
    }
}