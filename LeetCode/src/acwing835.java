import java.io.*;
import java.util.*;

public class Main{
    private static int N = 20000, idx = 0;
    private static int[][] tree = new int[N][26];
    private static int[] count = new int[N];
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        while(n -- > 0){
            String operation = in.next();
            String str = in.next();
            if(operation.equals("I")){
                insert(str);
            }else if(operation.equals("Q")){
                int times = query(str);
                System.out.println(times);
            }
        }
    }
    private static void insert(String str){
        int k = 0;
        for(int i = 0; i < str.length(); i ++){
            int u = str.charAt(i) - 'a';
            if(tree[k][u] == 0) tree[k][u] = ++ idx;
            k = tree[k][u];
        }
        count[k] ++;
    }

    private static int query(String str){
        int k = 0;
        for(int i = 0; i < str.length(); i ++){
            int u = str.charAt(i) - 'a';
            if(tree[k][u] == 0) return 0;
            k = tree[k][u];
        }
        return count[k];
    }
}