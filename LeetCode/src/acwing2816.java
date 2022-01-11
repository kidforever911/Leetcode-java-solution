import java.util.*;
import java.io.BufferedInputStream;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int m = in.nextInt();
        int n = in.nextInt();
        int[] a = new int[m];
        int[] b = new int[n];
        for(int i = 0; i < m; i ++){
            a[i] = in.nextInt();
        }
        for(int i = 0; i < n; i ++){
            b[i] = in.nextInt();
        }
        int i, j;
        for(i = 0, j = 0; j < n; j ++){
            if(i < m && a[i] == b[j]){
                i ++;
            }
        }
        if(i == m){
            System.out.print("Yes");
        }else{
            System.out.print("No");
        }
    }
}