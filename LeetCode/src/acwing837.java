import java.io.*;
import java.util.*;

public class Main{
    private static int N = (int) 1e5 + 10;
    private static int[] father = new int[N];
    private static int[] size = new int[N];
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int m = in.nextInt();
        for(int i = 1; i <= n; i ++){
            father[i] = i;
            size[i] = 1;
        }

        while(m -- > 0){
            String operation = in.next();
            if(operation.equals("C")){
                int left = in.nextInt();
                int right = in.nextInt();
                if(find(left) != find(right)){
                    size[find(right)] += size[find(left)];
                    father[find(left)] = find(right);
                }
            }else if(operation.equals("Q1")){
                int left = in.nextInt();
                int right = in.nextInt();
                if(find(left) == find(right)) System.out.println("Yes");
                else System.out.println("No");
            }else{
                int x = in.nextInt();
                System.out.println(size[find(x)]);
            }
        }

    }
    private static int find(int x){
        if(father[x] != x) father[x] = find(father[x]);
        return father[x];
    }
}