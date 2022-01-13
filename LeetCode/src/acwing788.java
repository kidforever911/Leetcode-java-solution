import java.util.*;
import java.io.BufferedInputStream;

public class Main{


    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] q = new int[n];
        for(int i = 0; i < n; i ++){
            q[i] = in.nextInt();
        }
        System.out.print(mergeSort(0, n - 1, q));
    }

    private static long mergeSort(int l, int r, int[] q){
        if(l >= r) return 0;
        int mid = l + r >> 1;
        long result = mergeSort(l, mid, q) + mergeSort(mid + 1, r, q);

        int k = 0, i = l, j = mid + 1;
        int[] temp = new int[q.length];
        while(i <= mid && j <= r){
            if(q[i] <= q[j]) temp[k ++] = q[i ++];
            else{
                temp[k ++] = q[j ++];
                result += mid - i + 1;
            }
        }
        while(i <= mid) temp[k ++] = q[i ++];
        while(j <= r) temp[k ++] = q[j ++];

        for(i = l, j = 0; i <= r; i ++, j ++) q[i] = temp[j];

        return result;
    }
}