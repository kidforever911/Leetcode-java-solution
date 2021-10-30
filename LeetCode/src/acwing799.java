import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.HashMap;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] arr = new int[n];
        HashMap<Integer, Integer> record = new HashMap<>();
        int result = 0;
        for(int i = 0; i < n; i ++){
            arr[i] = in.nextInt();
        }
        for(int i = 0, j = 0; i < n; i ++){
            record.put(arr[i], record.getOrDefault(arr[i], 0) + 1);
            while(j < i && record.get(arr[i]) > 1){
                record.put(arr[j], record.get(arr[j]) - 1);
                j ++;
            }
            result = Math.max(result, i - j + 1);
        }
        System.out.print(result);
    }
}