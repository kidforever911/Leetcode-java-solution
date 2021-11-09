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
        int[] result = new int[n];
        Stack<Integer> record = new Stack<>();
        for(int i = 0; i < n; i ++){
            while(record.size() != 0 && record.peek() >= arr[i]) record.pop();
            if(record.isEmpty()) result[i] = -1;
            else result[i] = record.peek();
            record.add(arr[i]);
        }
        for(int i = 0; i < n; i ++){
            System.out.print(result[i] + " ");
        }

    }
}