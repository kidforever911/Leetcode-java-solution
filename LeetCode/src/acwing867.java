import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        while(n -- > 0){
            int x = in.nextInt();
            primDecomposition(x);
        }
    }
    private static void primDecomposition(int x){
        for(int i = 2; i <= x / i; i ++){
            if(x % i == 0){
                int count = 0;
                while(x % i == 0){
                    x /= i;
                    count ++;
                }
                System.out.println(i + " " + count);
            }
        }
        if(x > 1) System.out.println(x + " " + 1);
        System.out.println();
        return;
    }


}