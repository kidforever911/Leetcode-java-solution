//quick sort
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
        
        quickSort(arr, 0, n - 1);
        
        for(int i = 0; i < n; i ++){
            System.out.print(arr[i] + " ");
        }
    }
    
    private static void quickSort(int[] arr, int left, int right){
        if(left >= right) return;
        
        int x = arr[left + right >> 1], i = left - 1, j = right + 1;
        while(i < j){
            do{
                i ++;
            }while(arr[i] < x);
            do{
                j --;
            }while(arr[j] > x);
            
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        quickSort(arr, left, j);
        quickSort(arr, j + 1, right);
    }
}