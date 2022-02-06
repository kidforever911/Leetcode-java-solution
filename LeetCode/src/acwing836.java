import java.util.*;
import java.io.*;

public class Main{
    private static int N = (int)10e5 + 10;
    private static int[] father = new int[N];
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();

        for(int i = 1; i <= n; i ++) father[i] = i;

        while(m -- > 0){
            String operation = in.next();
            int left = in.nextInt();
            int right = in.nextInt();
            if(operation.equals("M")) father[find(left)] = find(right);
            else if(operation.equals("Q")){
                if(find(left) == find(right)) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }


    private static int find(int x){
        if(father[x] != x) father[x] = find(father[x]);
        return father[x];
    }
}