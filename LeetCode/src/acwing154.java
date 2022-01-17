import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int N = (int) 1e6 + 10;
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[N];
        int[] q = new int[N];
        int hh = 0, tt = -1;
        for(int i = 0; i < n; i ++){
            arr[i] = in.nextInt();
        }
        for(int i = 0; i < n; i ++){
            if(hh <= tt && i - q[hh] + 1 > k) hh ++;
            while(hh <= tt && arr[q[tt]] >= arr[i]) tt --;
            q[++ tt] = i;
            if(i >= k - 1){
                System.out.print(arr[q[hh]] + " ");
            }
        }
        System.out.println();
        hh = 0;
        tt = -1;
        for(int i = 0; i < n; i ++){
            if(hh <= tt && i - q[hh] + 1 > k) hh ++;
            while(hh <= tt && arr[q[tt]] <= arr[i]) tt --;
            q[++ tt] = i;
            if(i >= k - 1){
                System.out.print(arr[q[hh]] + " ");
            }
        }
    }
}

