import java.util.*;
import java.io.*;

public class Main{
    private static int mod = (int)(1e9 + 7);
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        HashMap<Integer, Integer> record = new HashMap<>();
        while(n -- > 0){
            int x = in.nextInt();
            divisorNumber(x, record);
        }
        long result = 1;
        for(int nums : record.values()) result = result * (nums + 1) % mod;
        System.out.println(result);
    }

    private static void divisorNumber(int x, HashMap<Integer, Integer> record){
        for(int i = 2; i <= x / i; i ++){
            while(x % i == 0){
                record.put(i, record.getOrDefault(i, 0) + 1);
                x /= i;
            }
        }
        if(x > 1) record.put(x, record.getOrDefault(x, 0) + 1);
    }
}