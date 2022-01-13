import java.util.*;
import java.io.*;

public class Main{
    private static int N = 100010;
    private static int[] stack = new int[N];
    private static int tt = -1;

    public static void main(String[] args) throws  IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m=Integer.parseInt(reader.readLine());
        for(int i = 0; i < m; i ++){
            String[] s = reader.readLine().split(" ");
            String opt = s[0];
            if(opt.equals("push")){
                int x = Integer.parseInt(s[1]);
                stack[++ tt] = x;
            }else if(opt.equals("pop")){
                if(tt != -1) tt --;
            }else if(opt.equals("query")){
                System.out.println(stack[tt]);
            }else if(opt.equals("empty")){
                if(tt == -1) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}



