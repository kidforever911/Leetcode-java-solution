import java.util.*;
import java.io.*;

//方法1
public class Main{
    private static int N = 20;
    private static boolean[] used = new boolean[N];
    private static int[] path = new int[N];

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        dfs(0, n);
        return;
    }
    private static void dfs(int index , int n){
        if(index == n){
            for(int i = 0; i < n; i ++){
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i ++){
            if(!used[i]){
                used[i] = true;
                path[index] = i;
                dfs(index + 1, n);
                used[i] = false;
            }
        }
        return;
    }
}

