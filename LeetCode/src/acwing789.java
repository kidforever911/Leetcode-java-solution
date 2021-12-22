import java.util.Scanner;
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
        while(m > 0){
            int target = in.nextInt();
            find(arr, target);
            m --;
        }
    }

    private static void find(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while(left < right){
            int mid = left + right >> 1;
            if(arr[mid] >= target) right = mid;
            else left = mid + 1;
        }
        if(arr[left] != target) System.out.println("-1 -1");
        else{
            System.out.print(left + " ");
            left = 0;
            right = arr.length - 1;
            while(left < right){
                int mid = left + right + 1 >> 1;
                if(arr[mid] <= target) left = mid;
                else right = mid - 1;
            }
            System.out.println(left);
        }
    }
}