import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        while(n -- > 0){
            int x = in.nextInt();
            if(isPrime(x)) System.out.println("Yes");
            else System.out.println("No");
        }
    }

    private static boolean isPrime(int x){
        if(x < 2) return false;
        for(int i = 2; i <= x / i; i ++){
            if(x % i == 0) return false;
        }
        return true;
    }
}