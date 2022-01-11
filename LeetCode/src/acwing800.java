import java.util.*;
import java.io.BufferedInputStream;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int m = in.nextInt();
        int n = in.nextInt();
        int[] arrA = new int[m];
        int[] arrB = new int[n];
        int x = in.nextInt();
        for(int i = 0; i < m; i ++){
            arrA[i] = in.nextInt();
        }
        for(int i = 0; i < n; i ++){
            arrB[i] = in.nextInt();
        }
        int j = n - 1;
        for(int i = 0; i < n; i ++){
            while(j >= 0 && (arrA[i] + arrB[j] >= x)){
                if(arrA[i] + arrB[j] == x){
                    System.out.print(i + " " + j);
                }
                j --;
            }

        }

    }
}