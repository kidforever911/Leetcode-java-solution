import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String strA = reader.readLine();
        int[] ne = new int[n + 1];
        int m = Integer.parseInt(reader.readLine());
        String strB = reader.readLine();
        char[] p = new char[n + 1];
        char[] s = new char[m + 1];

        for(int i = 1; i <= n; i ++){
            p[i] = strA.charAt(i - 1);
        }
        for(int i = 1; i <= m; i ++){
            s[i] = strB.charAt(i - 1);
        }

        //计算ne数组
        for(int i = 2, j = 0; i <= n; i ++){
            while(j > 0 && p[i] != p[j + 1]) j = ne[j];
            if(p[i] == p[j + 1]) j ++;
            ne[i] = j;
        }

        //KMP匹配过程
        for(int i = 1, j = 0; i <= m; i ++){
            while(j > 0 && s[i] != p[j + 1]) j = ne[j];
            if(s[i] == p[j + 1]) j ++;
            if(j == n){
                writer.write(i - n + " ");
                j = ne[j];
            }
        }
        writer.flush();
        writer.close();
        reader.close();

    }
}