//merge sort
import java.util.Scanner;
import java.io.BufferedInputStream;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = in.nextInt();
        }
        mergeSort(arr, 0, n - 1);
        for(int i = 0; i < n; i ++){
            System.out.print(arr[i] + " ");
        }
    }

    private static void mergeSort(int[] arr, int left, int right){
        if(left >= right) return;
        int mid = left + right >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        int k = 0, i = left, j = mid + 1;
        int[] temp = new int [arr.length];
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]) temp[k ++] = arr[i ++];
            else temp[k ++] = arr[j ++];
        }
        while(i <= mid) temp[k ++] = arr[i ++];
        while(j <= right) temp[k ++] = arr[j ++];

        for(i = left, j = 0; i <= right; i ++, j ++) arr[i] = temp[j];
    }
}
