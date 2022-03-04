import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        while(n -- > 0){
            int a = in.nextInt();
            int b = in.nextInt();
            int result = gcd(a, b);
            System.out.println(result);
        }
        return;
    }

    private static int gcd(int a, int b){
        return b != 0 ? gcd(b, a % b) : a;
    }
}