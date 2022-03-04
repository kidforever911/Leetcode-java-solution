import java.util.*;
import java.io.*;

public class Main{
    private static int N = (int)1000010;
    private static int count = 0;
    private static int[] prime = new int[N];
    private static boolean[] used = new boolean[N];
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int x = in.nextInt();
        getPrime3(x);
        System.out.println(count);
    }

    //最普通筛质数，时间复杂度nlogn
    private static void getPrime1(int x){
        for(int i = 2; i <= x; i ++){
            if(!used[i]) prime[count ++] = x;
            for(int j = i; j <= x; j += i) used[j] = true;
        }
    }

    //优化后的筛质数，时间复杂度nloglogn
    private static void getPrime2(int x){
        for(int i = 2; i <= x; i ++){
            if(!used[i]){
                prime[count ++] = x;
                for(int j = i; j <= x; j += i) used[j] = true;
            }
        }
    }

    //线性筛法，时间复杂度n
    private static void getPrime3(int x){
        for(int i = 2; i <= x; i ++){
            if(!used[i]) prime[count ++] = i;
            for(int j = 0; prime[j] <= x / i; j ++){
                used[prime[j] * i] = true;
                if(i % prime[j] == 0) break;
            }
        }
    }
}