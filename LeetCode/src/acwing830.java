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

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        int N = 100010;
        int[] stk = new int[N];
        int tt = 0;
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        for(int i = 0; i < n; i ++){
            int x = in.nextInt();
            while(tt > 0 && stk[tt] >= x) tt --;
            if(tt > 0) System.out.print(stk[tt] + " ");
            else System.out.print("-1" + " ");

            stk[++ tt] = x;
        }
    }
}