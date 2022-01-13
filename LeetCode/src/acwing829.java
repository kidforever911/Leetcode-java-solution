import java.util.*;
import java.io.*;

public class Main{
    private static int N = 100010;
    private static int[] q = new int[N];
    private static int tt = -1;
    private static int hh = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        for(int i = 0; i < m; i ++){
            String[] s = reader.readLine().split(" ");
            if(s[0].equals("push")){
                int x = Integer.parseInt(s[1]);
                q[++ tt] = x;
            }else if(s[0].equals("pop")){
                if(tt != -1) hh ++;
            }else if(s[0].equals("query")){
                System.out.println(q[hh]);
            }else if(s[0].equals("empty")){
                if(tt < hh) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}