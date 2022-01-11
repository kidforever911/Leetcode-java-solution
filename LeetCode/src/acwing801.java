import java.util.*;
import java.io.BufferedInputStream;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = in.nextInt();
        }
        for(int i = 0; i < n; i ++){
            int count = lowBit(arr[i]);
            System.out.print(count + " ");
        }
    }

    private static int lowBit(int x){
        int res = 0;
        while(x > 0){
            x -= (x & (-x));
            res ++;
        }
        return res;
    }
}